package Java6_25.OJ;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 摊主的珠串
            String vendor = scanner.next();
            // 小红想买的珠串
            String want = scanner.next();
            // 输出结果
            buyOrNot(vendor, want);
        }

    }

    private static void buyOrNot(String vendor, String want) {
        // 遍历计算摊主有的
        HashMap<Character, Integer> V = new HashMap<Character, Integer>();
        for (int i = 0; i < vendor.length(); i++) {
            char c = vendor.charAt(i);
            V.put(c, V.getOrDefault(c, 0) + 1);
        }
        // 遍历小红想要的
        HashMap<Character, Integer> W = new HashMap<Character, Integer>();
        for (int i = 0; i < want.length(); i++) {
            char c = want.charAt(i);
            W.put(c, W.getOrDefault(c, 0) + 1);
        }
        // 缺少的
        int lack = 0;
        for (Map.Entry<Character, Integer> map : W.entrySet()) {
            char key = map.getKey();
            // 这种珠子小红需要的是多少
            int value = map.getValue();
            // 摊主的串中有多少
            int vendorValue = V.getOrDefault(key, 0);
            // 如果小红想要的多余摊主的，缺的就多了
            if (vendorValue < value) {
                lack +=  (value - vendorValue);
            }
        }
        if (lack == 0) {
            System.out.println("Yes " + (vendor.length()-want.length()));
        } else {
            System.out.println("No " + lack);
        }
    }
}
