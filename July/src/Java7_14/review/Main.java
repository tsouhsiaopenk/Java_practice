package Java7_14.review;

import java.util.Scanner;

/**
 * 字母统计：
 * 使用直接定值法
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int[] count = new int[26];
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    count[ch - 'A']++;
                }
            }
            for (int i = 0; i < count.length; i++) {
                System.out.printf("%c:%d%n", ('A' + i), count[i]);
            }
        }
    }
}
