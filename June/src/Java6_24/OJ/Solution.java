package Java6_24.OJ;

import org.junit.Test;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 1.读入密文
            String cipherText = scanner.nextLine();
            // 2.计算出来明文
            String clearText = getClearText(cipherText);
            // 3.输出明文
            System.out.println(clearText);
        }
    }

    private static String getClearText(String cipherText) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            if (c == ' '){
                sb.append(' ');
                continue;
            }
            char change = (char) (c - 5);
            if (change < 65){
                change = (char) (change + 26);
            }
            sb.append(change);
        }
        return sb.toString();
    }

    @Test
    public void m() {
        char tmp = 'A' + 5;
        System.out.println(tmp);
        System.out.println('A'+0);
        System.out.println('Z'+5);
    }
}
