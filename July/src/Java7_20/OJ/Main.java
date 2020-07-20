package Java7_20.OJ;

import org.junit.Test;

import java.util.Scanner;

/*
4
UTT-HELP
TUT-GLOP
310-GINO
000-1213
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
                String s = transform(strings[i]);
                // 格式化输出 XXX-XXXX
                String first = s.substring(0, 3);
                String second = s.substring(3);
                System.out.println(first + "-" + second);
            }
        }
    }

    private static String transform(String s) {
        // 1.先去掉 - 符号
        StringBuilder sb = new StringBuilder();
        for (String string : s.split("-")) {
            sb.append(string);
        }
        // 2.字母转数字
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            // 如果是字母，就转换为数字，数字不用管
            if (Character.isLetter(c)) {
                char tmp = getNumber(c);
                sb.setCharAt(i, tmp);
            }
        }
        return sb.toString();
    }

    @Test
    public void t2() {
        String str = "123-4567";
//        StringBuilder sb = new StringBuilder();
//        for (String string : str.split("-")) {
//            sb.append(string);
//        }
//        System.out.println(sb.toString());
//        System.out.println(sb.substring(0, 3) + "-" + sb.substring(3));
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(2, 'c');
        System.out.println(sb);
    }

    @Test
    public void t1() {
        char c = 'A';
        System.out.println(getNumber(c));
    }

    private static char getNumber(char c) {
        switch (c) {
            case 'A':
            case 'B':
            case 'C':
                return '2';
            case 'D':
            case 'E':
            case 'F':
                return '3';
            case 'G':
            case 'H':
            case 'I':
                return '4';
            case 'J':
            case 'K':
            case 'L':
                return '5';
            case 'M':
            case 'N':
            case 'O':
                return '6';
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
                return '7';
            case 'T':
            case 'U':
            case 'V':
                return '8';
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                return '9';
        }
        return '0';
    }
}
