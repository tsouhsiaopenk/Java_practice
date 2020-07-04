package Java7_4.Review;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 读入 IP 地址字符串
            String ip = scanner.nextLine();
            // 输入 10 进制表示的IP地址字符串
            String ip10 = scanner.nextLine();
            // 输出 转为 10 进制表示的IP地址字符串
            System.out.println(convertIP10(ip));
            // 输出 转为 2 进制表示的IP地址字符串
            System.out.println(convertIP(ip10));
        }
    }

    /*
        将给定的10进制地址，其中的十进制数字转化为二进制，然后补足八位，
        然后将二进制全部拼接起来，转化为十进制
     */
    private static long convertIP10(String ip) {
        String[] ips = ip.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ips.length; i++) {
            // 十进制转二进制字符串
            sb.append(binaryString(ips[i]));
        }
        return Long.parseLong(sb.toString(), 2);
    }

    // 十进制转换为8位二进制
    private static String binaryString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(s);
        int k = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int flag = (num & k) == 0 ? 0 : 1;
            sb.append(flag);
            num = num << 1;
        }
        return sb.toString();
    }

    private static String convertIP(String ip10) {
        StringBuilder sb = new StringBuilder();
        // 将10进制转换为二进制
        String ip2 = Long.toBinaryString(Long.parseLong(ip10));
        String as = "";
        // 不足32位的补足32位
        if (ip2.length() < 32) {
            for (int i = 0; i < 32 - ip2.length(); i++) {
                as += "0";
            }
        }
        ip2 = as + ip2;
        // IP地址每一段进行拼接
        String[] ips = new String[4];
        ips[0] = ip2.substring(0, 8);
        ips[1] = ip2.substring(8, 16);
        ips[2] = ip2.substring(16, 24);
        ips[3] = ip2.substring(24);
        for (int i = 0; i < 4; i++) {
            sb.append(Integer.parseInt(ips[i], 2));
            if (i != 3) {
                sb.append(".");
            }
        }
        return sb.toString();
    }


}
