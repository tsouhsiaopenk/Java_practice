package game;

import javax.websocket.Session;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理在线用户：
 *  一个程序中只需要一个在线用户管理器，这是一个单例类
 *  此处以懒汉的方式来实现
 */
public class OnlineUserManager {

    // 要保证线程安全
    private ConcurrentHashMap<Integer, Session> users = new ConcurrentHashMap<>();

    // 上线
    public void online(Integer userId,Session session){
        users.put(userId,session);
    }

    // 下线
    public void offline(Integer userId){
        users.remove(userId);
    }

    public Session getSession(Integer userId){
        return users.get(userId);
    }
    private OnlineUserManager() { }

    public static volatile OnlineUserManager instance = null;

    public static OnlineUserManager getInstance() {
        if (instance == null){
            synchronized (OnlineUserManager.class){
                if (instance == null){
                    instance = new OnlineUserManager();
                }
            }
        }
        return instance;
    }
}
