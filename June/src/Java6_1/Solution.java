package Java6_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    
    @Test
    public void t1() {
        String A = "aba";
        String B = "b";
        for (int index = 0; index < A.length(); index++) {
            String first = A.substring(0, index + 1);
            String second = A.substring(index + 1);
            System.out.println("first:" + first + " second:" + second + "   result:" + first + B + second);
        }
    }

    @Test
    public void t2() {
        String A = "aba";
        String B = "b";
        ArrayList<String> re = listAllStrings(A, B);
        for (String s : re) {
            System.out.println(s);
        }
    }
    @Test
    public void t3(){
        System.out.println(isPlalindrome("aba"));
    }
    // 判断输入的字符串是否为回文结构
    public static boolean isPlalindrome(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
        if (s.equals(s1)) {
            return true;
        }
        return false;
    }

    // 输入A，B字符串，返回组合后得字符串集合
    private static ArrayList<String> listAllStrings(String A, String B) {
        // 结果集合
        ArrayList<String> result = new ArrayList<>();
        // 合法校验
        if (A == null || B == null) {
            return null;
        }
        result.add(B + A);
        for (int index = 0; index < A.length(); index++) {
            String first = A.substring(0, index + 1);// 左闭右开区间
            String second = A.substring(index + 1);
            result.add(first + B + second);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        while (scanner.hasNextLine()) {
            String A = scanner.nextLine().trim();
            String B = scanner.nextLine().trim();
            ArrayList<String> allStrings = listAllStrings(A, B);
            for (String s:allStrings){
                if (isPlalindrome(s)){
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
