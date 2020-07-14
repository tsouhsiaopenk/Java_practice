package Java7_14.review;

import java.util.Scanner;

/**
 * 进制转换：十六进制转换为十进制
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().toUpperCase();
            long num = 0;
            // 开头的两个字母需要越过
            for (int i = 2; i < line.length(); i++) {
                num *= 16;
                char c = line.charAt(i);
                int n;
                if (c >= 'A' && c <= 'F') {
                    n = c - 'A' + 10;
                } else {
                    n = c - '0';
                }
                num += n;
            }
            System.out.println(num);
        }
    }
}
