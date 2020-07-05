package Java7_2.OJ;


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            // 输入密码
            String s = scanner.nextLine();
            // 要求 1 校验 ：长度超过八位
            boolean b1 = check1(s);
            // 要求 2 校验 ：包括大小写字母.数字.其他符号.以上四种至少三种
            boolean b2 = check2(s);
            // 要求 3 校验 : 不能有超过长度超2的字串重复
            boolean b3 = check3(s);
            if (b1 && b2 && b3){
                System.out.println("OK");
            }else {
                System.out.println("NG");
            }
        }
    }
    // 要求3校验：不能有相同长度超过2的字串
    private static boolean check3(String s) {
        // 字串校验
        for (int i = 0; i < s.length() - 2; i++) {
            // 从下标i开始，每次截取两个字符的字符串
            // 从下标i+1开始街区剩余的字符狗曾的字符串，判断是否包含a中街区的字符串
            // 包含说明出现重复，不包含说明没有重复
            String substr1 = s.substring(i,i+3);
            if (s.substring(i+1).contains(substr1)){
                return false;
            }
        }
        return true;
    }
    // 要求 2 校验 
    private static boolean check2(String s) {
        // 大写，小写，数字，其他
        boolean[] b = new boolean[4];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z'){
                b[0] = true;
            }else  if (c >= 'A' && c <= 'Z'){
                b[1] = true;
            }else if (c >= '0' && c <= '9'){
                b[2] = true;
            }else {
                b[3] = true;
            }
        }
        int count = 0;
        for (boolean value : b) {
            if (value) {
                count++;
            }
        }
        return count >= 3;
    }

    // 要求 1 校验 ： 长度超过8
    private static boolean check1(String s) {
//        if (s == null || s.length() <= 8){
//            return false;
//        }
        // return true;
        return s.length() > 8 && s!= null;
    }
}
