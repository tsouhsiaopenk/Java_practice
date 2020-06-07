package Java6_7.OJ;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // 输入 n 个整数，输出出现次数大于等于数组程度一半的数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            // 输入一组数字
            String string = scanner.nextLine().trim();
            // 计算出现测试大于等于 n / 2 的数
            String result = count(string);
            // 输出结果
            System.out.println(result);
        }
    }

    private static String count(String string) {
        String result = null;
        // 1.按照空格将输入的数字字符串进行拆分
        String[] strings = string.split(" ");
        // 2.使用 map 来计算出每个出现的数字字符串的个数
        Map<String, Integer> map = new HashMap<>();
        int len = strings.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(strings[i])) {
                // 先取出该 key 对应的 value 值
                int current = map.get(strings[i]);
                map.put(strings[i], current + 1);
            } else {
                map.put(strings[i], 1);
            }
        }
        // 3.找出 出现次数大于 n / 2 的数
        for (Object key : map.keySet()) {
            Integer value = map.get(key);
            if (value >= len / 2) {
                result = (String) key;
            }
        }
        return result;
    }
}
