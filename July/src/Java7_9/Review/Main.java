package Java7_9.Review;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 为了保证按照输入先后有序，使用LinkedHashMap
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        while (scanner.hasNext()) {
            String path = scanner.next();
            int id = path.lastIndexOf('\\');
            String fileName = id == -1 ? path : path.substring(id + 1);
            int line = scanner.nextInt();
            // 统计频率
            String key = fileName + " " + line;
            // map.put(key, map.getOrDefault(key, 0) + 1);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        // 对记录进行排序
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        // 只输出前8条
        int m = 0;
        for (Map.Entry<String, Integer> mapping : list) {
            if (m >= 8){
                break;
            }

            String[] str = mapping.getKey().split(" ");
            String fileName = str[0];

            // 只需要输出16位
            if (fileName.length() > 16) {
                fileName = fileName.substring(fileName.length() - 16);
            }
            String n = str[1];
            Integer count = mapping.getValue();
            System.out.printf("%s %s %d%n", fileName, n, count);
            m++;
        }
    }
}
