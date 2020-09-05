package Java7_20.OJ;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
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
        ArrayList<String> arrayList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
                String s = transform(strings[i]);
                // 格式化 XXX-XXXX
                String first = s.substring(0, 3);
                String second = s.substring(3);
                String result = first + "-" + second;
                if (!arrayList.contains(result)){
                    arrayList.add(result);
                }
            }
            Collections.sort(arrayList);
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println(arrayList.get(i));
            }
            System.out.println();
        }
    }

    private static String transform(String s) {
        // 结果集合
        StringBuilder sb = new StringBuilder();

        // 1.先去掉 - 符号
        s = s.replace("-", "");
        // 2.字母转数字
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是大写字母，就转换为数字，数字不用管
            if (Character.isUpperCase(c)) {
                char tmp = getNumber(c);
                sb.append(tmp);
            }else if(Character.isDigit(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    @Test
    public  void test(){
        String s = "BC1:51,C2:48.3";
        System.out.println(transform(s));
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
