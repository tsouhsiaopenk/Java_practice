package Java6_16.OJ;

import java.util.Scanner;

/**
 * 尼科彻斯定理：
 * 在于构造一个以(a * a - a + 1)为首项，以2为差的等差数列
 * 等差数列公式：n*a1 + n*(n - 1)*d/2
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int m = scanner.nextInt();
            String res = GetSequeOddNum(m);
            System.out.println(res);
        }
    }

    private static String GetSequeOddNum(int m) {
        int first = m * m - m + 1;
        String result = first + "+";
        for (int i = 1; i < m; i++) {
            first = first + 2;
            result += String.valueOf(first);
            if (i != m - 1) {
                result += "+";
            }
        }
        return result;
    }
}
