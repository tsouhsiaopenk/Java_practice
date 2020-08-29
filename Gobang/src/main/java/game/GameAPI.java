package game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

// 通过这个类处理 websocket 的相关通信逻辑
@ServerEndpoint(value="/game/{userId}")
public class GameAPI {
    /*
        这个类就表示服务器收到的 websocket 请求
        请求本来是两种，使用这一个类，就争取到把这两个类的情况都覆盖到
        严谨来说，应该用两个类表示两种请求
     */
    static class Request{
        public String type;
        public int userId;
        public String roomId;
        public int row;
        public int col;

        @Override
        public String toString() {
            return "Request{" +
                    "type='" + type + '\'' +
                    ", userId=" + userId +
                    ", roomId='" + roomId + '\'' +
                    ", row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    // 建立连接的时候实例化
    private int userId;


    @OnOpen
    public void onOpen(@PathParam("userId") String userIdStr, Session session){
        userId = Integer.parseInt(userIdStr);
        System.out.println("玩家建立连接 : " + userId);

        // 把玩家加入到在线玩家列表
        OnlineUserManager.getInstance().online(userId,session);
    }

    @OnClose
    public void onClose(){
        System.out.println("玩家断开连接 ：" + userId);

        // 把玩家从在线玩家列表中剔除
        OnlineUserManager.getInstance().offline(userId);
    }

    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("玩家断开连接 ：" + userId);

        // 把玩家从在线列表中剔除
        OnlineUserManager.getInstance().offline(userId);

        error.printStackTrace();
    }

    // OnMessage 收到的请求可能是匹配请求，也可能是落子请求，我们需要根据请求类型来判断
    //      如果type 是 startMatch 就处理匹配，如果是 putChess 就处理落子请求
    // message 请求的是一个json格式，直接使用第三方库
    @OnMessage
    public void OnMessage(String message,Session session) throws InterruptedException, IOException {
        System.out.printf("收到玩家 %d 的消息: %s",userId,message);

        // 实例化 Gson 对象
        Gson json = new GsonBuilder().create();
        // 将传进来的 json 数据 message 转换为 Java 对象
        Request request = json.fromJson(message,Request.class);

        // 类型判断
        if (request.type.equals("startMatch")){
            // 匹配逻辑
            Matcher.getInstance().addMatchQueue(request);
        }else if (request.type.equals("putChess")){
            // 落子逻辑
            Room curRoom = RoomManager.getInstance().getRoom(request.roomId);
            curRoom.putChess(request);
        }else{
            System.out.println("非法的 type 值" + request.type);
        }
    }
}
