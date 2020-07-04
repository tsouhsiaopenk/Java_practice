package Java7_4.OJ;

import java.util.Scanner;


// 奇偶校验
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            // 读入字符串
            String s = scanner.next();
            // 奇偶校验
            check(s);
        }
    }

    private static void check(String s) {
        for (int i = 0; i < s.length(); i++) {
            // 得到字符的 ascii 码值
            int asc = getInt(s.charAt(i));
            // 十进制转二进制
            String binary = Integer.toBinaryString(asc);
            // 补足 8 位
            String res = eightBit(binary);
            // 输出结果
            System.out.println(res);
        }
    }

    private static String eightBit(String binary) {
        // 求出奇校验的值
        int count  = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1'){
                count++;
            }
        }
        StringBuilder sb = new StringBuilder(binary);
        sb.reverse();
        while (sb.length() < 7){
            sb.append('0');
        }
        if (count % 2 == 0){
            sb.append('1');
        }else {
            sb.append('0');
        }
        return sb.reverse().toString();
    }

    private static int getInt(char c) {
        return c;
    }
}
