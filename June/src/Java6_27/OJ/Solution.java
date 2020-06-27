package Java6_27.OJ;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 怪物数量
            int n = scanner.nextInt();
            // 小易的初始能力值
            int a = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                if (arr[i] <= a) {
                    a += arr[i];
                } else {
                    a += gcd(a, arr[i]);
                }
            }
            System.out.println(a);
        }
    }
    // 求最大公约数
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
