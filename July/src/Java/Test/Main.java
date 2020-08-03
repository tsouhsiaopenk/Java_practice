package Java.Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            // n 张桌子每张可以容纳的最大人数
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            // m 批客人的人数和预计消费金额
            int[] b = new int[m];
            int[] c = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = scanner.nextInt();
                c[i] = scanner.nextInt();
            }
        }
    }
}
