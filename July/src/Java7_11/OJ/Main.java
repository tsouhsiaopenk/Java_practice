package Java7_11.OJ;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            // 输入一行字符串
            String str = scanner.nextLine();
            Map<Character, Integer> stat = new HashMap<>();
            for (int i = 0; i < 26; i++) {
                stat.put((char) ('A' + i), 0);
            }
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                // 包含就说明在 A-Z的范围中
                if (stat.containsKey(c)) {
                    stat.put(c, stat.get(c) + 1);
                }
            }
            // 最后打印出来
            for (Map.Entry<Character, Integer> map : stat.entrySet()) {
                System.out.println(map.getKey() + ":" + map.getValue());
            }
        }
    }

    @Test
    public void test() {
        int a = 'A';
        int b = 2;
        System.out.println((char) ('A' + b));
    }
}
