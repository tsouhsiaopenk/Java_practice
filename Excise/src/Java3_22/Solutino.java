package Java3_22;

import java.util.Scanner;

class Solution {
    public static byte charToByteAscall(char ch) {
        return (byte) ch;
    }

    public static char intAscallToChar(int ascall) {
        return (char) ascall;
    }

    public static void main(String[] args) {
        // 输入一个字符串
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        // 排除特殊情况
        if (str.length() == 0 || str.length() > 100) {
            return;
        }

        // 散列法,26个小写字母对应26个下标，凡是出现的字母，将其对应下标数组状态置为true
        boolean[] hash = new boolean[26];

        for (int i = 0; i < str.length(); i++) {
            int index = charToByteAscall(str.charAt(i)) - 97;
            // 若此状态还没有改变，就改变
            if (hash[index] == false) {
                hash[index] = true;
            }
        }
//        for (int i = 0; i < 25; i++) {
//            System.out.print(hash[i] + " ");
//        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] == true) {
                System.out.print(intAscallToChar(i + 97));
            }
        }
    }
}
