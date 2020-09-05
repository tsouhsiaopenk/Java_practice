package Java7_1.OJ;

import org.junit.Test;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 输入ip地址，为字符串
            String ip = scanner.next();
            // 输入10进制型ip地址
            int ipi = scanner.nextInt();

            /********************* 第一大部分：处理输入的是字符串的ip地址****************************/
            // 根据点将ip分成几个部分
            // (如果用“.”作为分隔的话,必须是如下写法,String.split("\\."),这样才能正确的分隔开,不能用String.split("."); )
            String[] ips = ip.split("\\.");
            // 然后将字符串数组转化为整型数组
            int[] arrIP = new int[ips.length];
            for (int i = 0; i < ips.length; i++) {
                arrIP[i] = Integer.parseInt(ips[i]);
            }
            StringBuilder combine = new StringBuilder();
            for (int i = 0; i < ips.length; i++) {
                // 从前到后读取每段ip地址的整数，将其转化为二进制
                String s = Integer.toBinaryString(arrIP[i]);
                // 补足八位后
                String s1 = getBinary(s);
                combine.append(s1);
            }
            int longIP = Integer.parseUnsignedInt(combine.toString(), 2);
            System.out.println(longIP);

            /*****************************第二大部分：处理输入的是整数********************************/
            // 1.将输入的整型ip地址转化为二进制字符串
            String s = Integer.toBinaryString(ipi);
            // 2.将字符串补足32位
            String s1 = getBinary32(s);
            // 3.每八位读取一次
            String[] strings = new String[4];
            strings[0] = s1.substring(0, 8); // 0 -7
            strings[1] = s1.substring(8, 16); // 8 - 15
            strings[2] = s1.substring(16, 24); // 16 - 23
            strings[3] = s1.substring(24,32); // 24-31
            int[] arr = new int[4];
            for (int i = 0; i < 4; i++) {
                // 二进制转10进制字符串
                arr[i] = Integer.parseUnsignedInt(strings[i], 2);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
                if (i != arr.length - 1) {
                    sb.append('.');
                }
            }
            System.out.println(sb.toString());
        }
    }

    private static String getBinary32(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        while (sb.length() < 32) {
            sb.append(0);
        }
        return sb.reverse().toString();
    }

    // 用来将表示二进制的字符串补足八位
    private static String getBinary(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        while (sb.length() < 8) {
            sb.append(0);
        }
        return sb.reverse().toString();
    }

    @Test
    public void Test() {
        String s = Integer.toBinaryString(3);
        String s1 = getBinary32(s);
        System.out.println(s1);//10.0.3.193
        // 167969729
    }
}
