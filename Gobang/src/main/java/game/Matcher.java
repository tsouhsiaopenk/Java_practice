package game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.websocket.Session;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
    这个类用来实现匹配功能
    内部管理一个匹配队列,这个类也是一个单例类.
    这里要做的是模拟生产-消费这样的一种东西，将所有的匹配请求添加到一个请求队列中，
    然后借助一个额外的线程来实现匹配。只要在请求队列中找到两个请求就进行匹配
 */
public class Matcher {
    Gson gson = new GsonBuilder().create();

    // 封装返回的数据类型 ————表示匹配成功后的响应数据
    static class MatchResponse{
        public String type;
        public String roomId;
        public boolean isWhite;
        public int otherUserId;
    }
    private BlockingQueue<GameAPI.Request> queue = new LinkedBlockingQueue<>();

    // 实现插入到阻塞队列中的方法
    public void addMatchQueue(GameAPI.Request request) throws InterruptedException {
        queue.put(request);
    }

    // 使用一个线程进行实时扫描,在构造实例时候创建线程
    private Matcher(){
        new Thread(){
            @Override
            public void run() {
                while (true){
                    handlerMatch();
                }
            }
        }.start();
    }

    // 实现一次匹配的过程
    private void handlerMatch() {
        try {
            // 1.从阻塞队列中取出两个玩家的信息
            GameAPI.Request player1 = queue.take();
            GameAPI.Request player2 = queue.take();
            System.out.println("匹配到两个玩家" + player1.userId + "," + player2.userId);
            // 2.检查两个玩家是否在线，处理玩家下线的情况，也要处理一下玩家自己匹配到自己的情况。
            //      （例如，玩家点了匹配之后，进入队列，关闭页面，再次点击匹配，有可能出现自己匹配自己的情况）
            //        更严格的处理方式应该是服务器告诉客户端当前的状态（空闲，匹配中，游戏中，下线）
            OnlineUserManager manager = OnlineUserManager.getInstance();
            Session session1 = manager.getSession(player1.userId);
            Session session2 = manager.getSession(player2.userId);
            // 如果玩家不在线，其对应的session就为null
            if (session1 == null){
                // 玩家 1 不在线,将其请求信息从队列中删除
                queue.put(player2);
                System.out.println("玩家2 不在线");
                return;
            }
            if (session2 == null){
                queue.put(player1);
                System.out.println("玩家1 不在线");
                return;
            }
            if (session1 == session2){
                // 自己匹配到自己的极端情况
                queue.put(player1);
                System.out.println("自己匹配到自己！！");
                return;
            }
            // 3.把两个玩家加入到同一个游戏房价中
            //      此处引入房房对象，还需要把房间对象管理起来
            Room room = new Room();
            room.setPlayerId1(player1.userId);
            room.setPlayerId2(player2.userId);
            // 引入一个 “房间管理器” 对象，来组织房间
            RoomManager.getInstance().addRoom(room);
            System.out.println("玩家进入房间成功！roomID: " + room.getRoomId());
            // 4.分别给玩家 1 发送匹配响应，告诉玩家，匹配成功，对手是谁，房间号是多少，
            //      按照前面所约定的响应格式，把匹配成功的结果告诉客户端。
            MatchResponse response1 = new MatchResponse();
            response1.type = "startMatch";
            response1.roomId = room.getRoomId();
            response1.isWhite = true;
            response1.otherUserId = player2.userId;
            String respJson1 = gson.toJson(response1);
            session1.getBasicRemote().sendText(respJson1);
            System.out.println("给玩家1响应 ：" + respJson1);

            // 5.分别给玩家2 发送匹配响应
            MatchResponse response2 = new MatchResponse();
            response2.type = "startMatch";
            response2.roomId = room.getRoomId();
            response2.isWhite = false;
            response2.otherUserId = player1.userId;
            String respJson2 = gson.toJson(response2);
            session2.getBasicRemote().sendText(respJson2);
            System.out.println("给玩家2响应 ：" + respJson2);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    private static volatile Matcher instance = null;

    public static Matcher getInstance(){
        if (instance == null){
            synchronized (Matcher.class){
                if (instance == null){
                    instance = new Matcher();
                }
            }
        }
        return instance;
    }
}
