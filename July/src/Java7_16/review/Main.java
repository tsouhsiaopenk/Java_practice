package Java7_16.review;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int n, m, maxRemainEnergy;
    static int[][] map;
    static boolean flag = false;
    static String path = "";
    static LinkedList<String> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        // 输入
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int P = scanner.nextInt();
        map = new int[n][m]; // n 行 m 列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        // 处理
        runMap(0, 0, P);

        // 输出
        if (!flag) {
            System.out.println("Can not escape!");
        } else {
            System.out.println(path);
        }
    }

    private static void runMap(int x, int y, int energy) {
        if (energy < 0 || x < 0 || y < 0 || x >= n || y >= m || map[x][y] != 1) {
            return;
        } else {
            linkedList.offer("[" + x + "," + y + "]");
            map[x][y] = 0;
            // 如果到达了终点
            if (x == 0 && y == m - 1) {
                if (energy >= maxRemainEnergy) {
                    maxRemainEnergy = energy;
                    updatePath();
                }
                map[x][y] = 1;
                linkedList.removeLast();
                flag = true;
                return;
            }
            // 向右
            runMap(x, y + 1, energy - 1);
            // 向下
            runMap(x + 1, y, energy);
            // 向上
            runMap(x - 1, y, energy - 3);
            // 向左
            runMap(x, y - 1, energy - 1);
            map[x][y] = 1;
            linkedList.removeLast();
        }
    }

    private static void updatePath() {
        // 按照题目要求，走过的路径为坐标[x,y]的形式，每两个坐标之间用，隔开
        StringBuilder sb = new StringBuilder();
        // 为每个左边后边加","
        for (String s : linkedList) {
            sb.append(s).append(",");
        }
        // 删除最后一个","
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        path = sb.toString();
    }
}
