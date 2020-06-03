package Java6_3.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    // 在一行内输出str中里连续最长的数字串
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();
            System.out.println(maxSubString(s));
        }
    }

    private static String maxSubString(String s) {
        // 1.求出字符串s中的所有数字字串，存放在字符串集合中
        ArrayList<String> strings = listAllNumString(s);
        // 2,按照长度进行排序(从大到小)
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        // 返回第 1 个字符串
        return strings.get(0);
    }

    private static ArrayList<String> listAllNumString(String s) {
        ArrayList<String> result = new ArrayList<>();
        int begin = 0;
        int end = 0;
        while (begin < s.length() && end < s.length()) {
            while (begin < s.length() && (!isNumber(s.charAt(begin)))) {
                begin++;
            }
            end = begin;
            while (end < s.length() && isNumber(s.charAt(end))) {
                end++;
            }
            // subString() 方法是左闭右开
            result.add(s.substring(begin, end));
            begin = end + 1;
        }
        return result;
    }

    private static boolean isNumber(char c) {
        if ('0' <= c && c <= '9') {
            return true;
        }
        return false;
    }
}
