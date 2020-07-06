package Java7_6.Review;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 输入一个正整数
            int n = scanner.nextInt();
            long sum1 = factorial(n);
            long sum2 = count(n);
            // 将得到的分子分母进行相除，就能到的概率
            double res = (sum2*1.0/sum1) * 100;
            System.out.println(String.format("%.2f", res) + "%");
            // System.out.printf("%.2f%%",res);
        }
    }

    // 错误排列算法
    private static long count(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }
        return (n - 1) * (count(n - 1) + count(n - 2));
    }

    // n 的阶乘
    private static long factorial(int n) {
        long res = 1; // int 类型不行
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
