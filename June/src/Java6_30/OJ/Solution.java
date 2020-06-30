package Java6_30.OJ;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 候选人数
            int candidates = scanner.nextInt();
            // 候选人名单
            String[] candidate = new String[candidates];
            for (int i = 0; i < candidates; i++) {
                candidate[i] = scanner.next();
            }
            // 投票人数
            int voter = scanner.nextInt();
            // 投票
            String[] vote = new String[voter];
            for (int i = 0; i < voter; i++) {
                vote[i] = scanner.next();
            }
            Map<String, Integer> map = new LinkedHashMap<>();
            for (String s : candidate) {
                map.put(s, 0);
            }
            map.put("Invalid", 0);
            for (String s : vote) {
                if (map.keySet().contains(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put("Invalid", map.get("Invalid") + 1);
                }
            }
            for (Map.Entry<String, Integer> m : map.entrySet()) {
                System.out.println(m.getKey() + " : " + m.getValue());
            }
        }
    }
}
