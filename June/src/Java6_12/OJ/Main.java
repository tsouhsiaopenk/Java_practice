package Java6_12.OJ;


import java.util.*;

/**
 * 个位数统计
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            // 由于打印的是键值对的形式，我们这里就用map来实现
            Map<Character, Integer> map = new HashMap<>();
            // 为了保证打印时候的有序性，先将0-9的次序放入键值对中
            for (int i = 0; i < 10; i++) {
                if (s.contains(String.valueOf(i))) {
                    map.put(convert(i), 0);
                }
            }
            // 遍历字符串，进行统计计算
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
            // 输出操作
            for (Map.Entry entry : map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }

    private static char convert(int i) {
        switch (i) {
            case 0:
                return '0';
            case 1:
                return '1';
            case 2:
                return '2';
            case 3:
                return '3';
            case 4:
                return '4';
            case 5:
                return '5';
            case 6:
                return '6';
            case 7:
                return '7';
            case 8:
                return '8';
            case 9:
                return '9';
        }
        return ' ';
    }
}
