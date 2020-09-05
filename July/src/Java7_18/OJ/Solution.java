package Java7_18.OJ;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 输入一串要加密的字符串
            String encrypt = scanner.next();
            // 输入一串要解密的字符串
            String decrypt = scanner.next();
            // 得到加密后的字符串
            String toEncrypt = getEncrypt(encrypt);
            // 得到解密后的字符串
            String toDecrypt = getDecrypt(decrypt);
            // 输出
            System.out.println(toEncrypt);
            System.out.println(toDecrypt);
        }
    }

    // 加密字符串
    private static String getEncrypt(String encrypt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encrypt.length(); i++) {
            char c = encrypt.charAt(i);
            if (Character.isUpperCase(c)) {
                // 大写字母
                if ('A' <= c && c <= 'Y') {
                    c = (char) (c + 1);
                }else if (c == 'Z'){
                    c = 'A';
                }
                c = Character.toLowerCase(c);
                sb.append(c);
            } else if (Character.isLowerCase(c)) {
                // 小写字母
                if ('a' <= c && c <= 'y') {
                    c = (char) (c + 1);
                }else if (c == 'z'){
                    c = 'a';
                }
                c = Character.toUpperCase(c);
                sb.append(c);
            } else if (Character.isDigit(c)) {
                // 数字
                if ('0' <= c && c <= '8'){
                    c = (char) (c + 1);
                }else if (c == '9'){
                    c = '0';
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // 解密字符串
    private static String getDecrypt(String decrypt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < decrypt.length(); i++) {
            char c = decrypt.charAt(i);
            if (Character.isUpperCase(c)) {
                // 大写字母
                if ('B' <= c && c <= 'Z') {
                    c = (char) (c - 1);
                }else if (c == 'A'){
                    c = 'Z';
                }
                c = Character.toLowerCase(c);
                sb.append(c);
            } else if (Character.isLowerCase(c)) {
                // 小写字母
                if ('b' <= c && c <= 'z') {
                    c = (char) (c - 1);
                }else if (c == 'a'){
                    c = 'z';
                }
                c = Character.toUpperCase(c);
                sb.append(c);
            } else if (Character.isDigit(c)) {
                // 数字
                if ('1' <= c && c <= '9'){
                    c = (char) (c - 1);
                }else if (c == '0'){
                    c = '9';
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
