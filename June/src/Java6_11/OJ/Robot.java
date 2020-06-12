package Java6_11.OJ;

public class Robot {
    /*
        机器人只能向下或者向右，就意味着每向下或者向右走一步，格子少了一行或者一列.
        经过分析发现，x 或者 y 为 1 的时候，只有一条路径供机器人从左上角走到右下角
        ...
     */
    public int countWays(int x, int y) {
        // write code here

        if (x == 1 || y == 1) {
            return 1;
        }
        return countWays(x - 1, y) + countWays(x, y - 1);
    }
}
