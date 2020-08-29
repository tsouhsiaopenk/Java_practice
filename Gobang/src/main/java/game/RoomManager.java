package game;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 这是一个单例类，负责管理若干个房间。
 *      使用一个 hash 表把房间存储起来。
 *          key就是roomId,value 就是 Room 对象
 */
public class RoomManager {

    private ConcurrentHashMap<String,Room> rooms = new ConcurrentHashMap<>();

    public void addRoom(Room room){
        rooms.put(room.getRoomId(),room);
    }

    public void removeRoom(String roomId){
        rooms.remove(roomId);
    }

    public Room getRoom(String roomId){
        return rooms.get(roomId);
    }

    private RoomManager() { }

    private static volatile RoomManager instance = null;
    public static RoomManager getInstance(){
        if (instance == null){
            synchronized (RoomManager.class){
                if (instance == null){
                    instance = new RoomManager();
                }
            }
        }
        return instance;
    }
}
