package Java7_19.review;

import java.util.Scanner;

/**
 * 回文串
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (isPalindrome(s.substring(0, s.length() - 1))
                    || isPalindrome(s.substring(1, s.length()))
                    || isPalindrome(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    // 判断是否为回文串
    private static boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
