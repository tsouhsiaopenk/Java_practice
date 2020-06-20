package Java6_19.OJ;

import java.util.Scanner;

/**
 * 火车进站
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            // 输入火车数量
            int N = scanner.nextInt();
            int[] trains = new int[N];
            // 输入每一组
            for (int i = 0; i < N; i++) {
                trains[i] = scanner.nextInt();
            }

        }
    }
}
