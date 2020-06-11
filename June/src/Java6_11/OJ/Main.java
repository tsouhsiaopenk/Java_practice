package Java6_11.OJ;


import org.junit.Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int step = needStep(n);
            System.out.println(step);
        }
    }

    private static int needStep(int n) {
        // 如果就是斐波那契数的话，返回0
        if (isFibonacci(n)) {
            return 0;
        }
        int leftStep = 0;
        int rightStep = 0;
        int leftTmp = n;
        int rightTmp = n;
        while (!isFibonacci(leftTmp)) {
            leftTmp--;
            leftStep++;
        }
        while (!isFibonacci(rightTmp)) {
            rightTmp++;
            rightStep++;
        }
        return Math.min(leftStep, rightStep);
    }

    // 判断这个数字是否为斐波那契数
    private static boolean isFibonacci(int n) {
        for (int i = 0; fibonacci(i) < n; i++) {
            if (fibonacci(i + 1) == n) {
                return true;
            }
        }
        return false;
    }

    // n 表示为第几个fibonacci数列数
    private static int fibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int tmp1 = 1;
        int tmp2 = 1;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = tmp1 + tmp2;
            tmp1 = tmp2;
            tmp2 = res;
        }
        return res;
    }

}
