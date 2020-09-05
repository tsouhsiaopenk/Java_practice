package Java7_13.OJ;

import java.util.Scanner;

/**
 * 地下迷宫
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            // 体力值
            int P = scanner.nextInt();
            // n*m的格子迷宫
            int[][] maze = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }

        }
    }
}
