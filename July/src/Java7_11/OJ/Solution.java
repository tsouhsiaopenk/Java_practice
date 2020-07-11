package Java7_11.OJ;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 进制转换：
 * 先将十六进制转换为二进制，然后将二进制转换为16进制
 */
public class Solution {
    static Map<String, String> map = new HashMap<String, String>() {
        {
            put("0", "0000");
            put("1", "0001");
            put("2", "0010");
            put("3", "0011");
            put("4", "0100");
            put("5", "0101");
            put("6", "0110");
            put("7", "0111");
            put("8", "1000");
            put("9", "1001");
            put("A", "1010");
            put("B", "1011");
            put("C", "1100");
            put("D", "1101");
            put("E", "1110");
            put("F", "1111");
        }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String hexString = scanner.next();
            // 十六进制转二进制
            StringBuilder sb = new StringBuilder();
            // 跳过前边的 0x
            for (int i = 2; i < hexString.length(); i++) {
                sb.append(map.get(hexString.charAt(i) + ""));
            }
            // 二进制 转 十进制
            String binaryString = sb.reverse().toString();
            int decimal = 0;
            for (int i = 0; i < binaryString.length(); i++) {
                int factor = Integer.parseInt(binaryString.charAt(i)+"");
                decimal += Math.pow(2,i) * factor;
            }
            System.out.println(decimal);
        }
    }

    @Test
    public void test() {
        System.out.println(Integer.toBinaryString(12));

    }
}
