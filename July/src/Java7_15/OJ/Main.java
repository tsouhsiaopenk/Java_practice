package Java7_15.OJ;

import java.util.Scanner;

/**
 * 回文串
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            // 输入字符串
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                String left = line.substring(0, i);
                // System.out.println(left);
                String right = line.substring(i);
                // System.out.println(right);
                String newLine = left + " " + right;
                // System.out.println(newLine);
                char c = newLine.charAt(newLine.length() - 1 - i);
                newLine = newLine.replace(" ", c+"");
                if (isHuiWen(newLine)){
                    // 找到不必再循环
                    break;
                }
            }
        }
    }

    private static boolean isHuiWen(String newLine) {
        String reverse = new StringBuilder(newLine).reverse().toString();
        if (newLine.equals(reverse)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
            return false;
        }
        return true;
    }
}
