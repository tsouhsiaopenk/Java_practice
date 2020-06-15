package java6_15.Review;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int a = 1;
        int b = 1;
        int c = 1;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        while (c < n) {
            a = b;
            b = c;
            c = a + b;
        }
        // 最后 n 在 b 和 c 这两个斐波那契数之间
        int dis1 = n - b;
        int dis2 = c - n;
        System.out.println(dis1 < dis2 ? dis1 : dis2);
    }
}
