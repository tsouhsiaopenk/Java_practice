package game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.websocket.Session;
import java.io.IOException;
import java.util.UUID;

/**
 * 通过这个类来表示一个房间。每两个玩家就构成了一个房间，由于服务器的玩家可能很多，
 * 此时程序中就会存在多个房间实例。
 * <p>
 * 房间需要记录玩家信息（房间号，对战的两个玩家），还需要记录游戏状态，当前棋盘是怎么样的
 * 和前端实现一样，这里还是用二维数组来表示棋盘当前的状态.
 * (棋盘中的每个元素是个整数，约定：
 * 0-该位置为空
 * 1-该位置为玩家1的棋子
 * 2-该位置为玩家2的棋子)
 */
public class Room {
    public static class putChessResponse {
        public String type = "putChess";
        public int userId;
        public int row;
        public int col;
        public int winner;
    }

    // 玩家信息
    private String roomId;
    private int playerId1;
    private int playerId2;
    // 游戏信息
    private static final int MAX_ROW = 15;
    private static final int MAX_COL = 15;
    private int[][] chessBoard = new int[MAX_ROW][MAX_COL];

    public Room() {
        // 此处只需要确保房间号(roomId)唯一,其他属性都是匹配玩家对弈过程中设定的
        roomId = UUID.randomUUID().toString();
    }

    // 准备一个Gson对象
    private Gson gson = new GsonBuilder().create();

    public int getPlayerId1() {
        return playerId1;
    }

    public void setPlayerId1(int playerId1) {
        this.playerId1 = playerId1;
    }

    public int getPlayerId2() {
        return playerId2;
    }

    public void setPlayerId2(int playerId2) {
        this.playerId2 = playerId2;
    }

    public String getRoomId() {
        return roomId;
    }

    public void putChess(GameAPI.Request request) throws IOException {
        // 1.进行落子
        int chess = request.userId == playerId1 ? 1 : 2;
        int row = request.row;
        int col = request.col;
        if (chessBoard[row][col] != 0) {
            // 此位置已经被其他棋子占用，不能下棋
            // 请求有误
            System.out.println("落子位置有误！" + request);
            return;
        }
        chessBoard[row][col] = chess;
        // 打印出棋盘，方便调试
        printChessBoard();
        // 2.检查游戏是否结束
        int winner = chessWinner(row, col, chess);
        // 3.把响应写回客户端
        //      需要给两个玩家都发送响应，发送的是同一对象
        putChessResponse response = new putChessResponse();
        response.userId = request.userId;
        response.row = row;
        response.col = col;
        response.winner = winner;
        // 给玩家写数据，需要获得玩家的session对象
        OnlineUserManager manager = OnlineUserManager.getInstance();
        Session session1 = manager.getSession(playerId1);
        Session session2 = manager.getSession(playerId2);
        if (session1 == null) {
            // 玩家1断开连接，我们就认为玩家2赢了
            response.winner = playerId2;
        }
        if (session2 == null) {
            // 玩家2断开连接，我们就认为玩家2赢了
            response.winner = playerId1;
        }
        String respJson = gson.toJson(response);
        if (session1 != null) {
            session1.getBasicRemote().sendText(respJson);
        }
        if (session2 != null) {
            session2.getBasicRemote().sendText(respJson);
        }
        // 打印出winner的值，便于调试
        System.out.println(winner);
        // 4.若胜负已分，销毁房间即可
        if (response.winner != 0) {
            RoomManager.getInstance().removeRoom(roomId);
            System.out.println("房间已经被销毁 roomId = " + roomId);
        }
    }


    private int chessWinner(int row, int col, int chess) {
        // 是否分出输赢
        boolean done = false;
        // 1.检查所有行
        for (int c = col - 4; c <= col; c++) {
            if (c < 0 || c >= MAX_COL) {
                continue;
            }
            if (chessBoard[row][c] == chess
                    && chessBoard[row][c + 1] == chess
                    && chessBoard[row][c + 2] == chess
                    && chessBoard[row][c + 3] == chess
                    && chessBoard[row][c + 4] == chess
            ) {
                done = true;
            }
        }
        // 检查所有列
        for (int r = row - 4; r <= row; r++) {
            if (r < 0 || r >= MAX_ROW) {
                continue;
            }
            if (chessBoard[r][col] == chess
                    && chessBoard[r + 1][col] == chess
                    && chessBoard[r + 2][col] == chess
                    && chessBoard[r + 3][col] == chess
                    && chessBoard[r + 4][col] == chess
            ) {
                done = true;
            }
        }
        // 检查左对角线
        for (int r = row - 4, c = col - 4; r <= row && c <= col; r++, c++) {
            if (r < 0 || r >= MAX_ROW || c < 0 || c >= MAX_COL) {
                continue;
            }
            if (chessBoard[r][c] == chess
                    && chessBoard[r + 1][c + 1] == chess
                    && chessBoard[r + 2][c + 2] == chess
                    && chessBoard[r + 3][c + 3] == chess
                    && chessBoard[r + 4][c + 4] == chess
            ) {
                done = true;
            }
        }
        // 检查右对角线
        for (int r = row - 4, c = col + 4; r <= row && c >= col; r++, c--) {
            if (r < 0 || r >= MAX_ROW || c < 0 || c >= MAX_COL) {
                continue;
            }
            if (chessBoard[r][c] == chess
                    && chessBoard[r + 1][c - 1] == chess
                    && chessBoard[r + 2][c - 2] == chess
                    && chessBoard[r + 3][c - 3] == chess
                    && chessBoard[r + 4][c - 4] == chess
            ) {
                done = true;
            }
        }
        if (!done) {
            return 0;
        }
        return chess == 1 ? playerId1 : playerId2;
    }

    private void printChessBoard() {
        for (int row = 0; row < MAX_ROW; row++) {
            for (int col = 0; col < MAX_COL; col++) {
                System.out.print(chessBoard[row][col] + " ");
            }
            System.out.println();
        }
    }
}
