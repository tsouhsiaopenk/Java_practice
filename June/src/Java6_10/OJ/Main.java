package Java6_10.OJ;

import java.util.Scanner;

/**
 * 末尾0的个数：
 * 1，先求阶乘
 * 2，再从结果中求0的个数
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            // 输入一个整数 n
            int n = scanner.nextInt();
            // 计算阶乘
            // int fact = factorial(n);
            // 计算0的个数
            int number = zeroNum(n);
            // 输出结果
            System.out.println(number);
        }
    }

    private static int zeroNum(int n) {
        // 求 5
        int count = 0;
        for (int i = 0; i < n; i++) {
            n /= 5;
            count += n;
        }
        return count;
    }

//    private static int zeroNum(int fact) {
//        int count = 0;
//        while (fact/10 == 0) {
//            count++;
//            fact /= 10;
//        }
//        return count;
//    }

//    private static int factorial(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        int res = 1;
//        for (int i = 1; i <= n; i++) {
//            res *= i;
//        }
//        return res;
//    }

}
