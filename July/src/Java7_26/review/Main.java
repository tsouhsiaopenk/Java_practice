package Java7_26.review;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        while (scanner.hasNext()) {
            // 文件名称
            String str = scanner.next();
            // 错误行号
            int errorLine = scanner.nextInt();
            // 根据 \ 切割
            String[] arr = str.split("\\\\");
            String fileName = arr[arr.length - 1];
            // 截取出16位
            if (fileName.length() > 16) {
                fileName = fileName.substring(fileName.length() - 16);
            }
            String key = fileName + " " + errorLine;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        for(String string :map.keySet()){
            count++;
            if (count > (map.keySet().size() - 8)){
                // 输出最后八个记录
                System.out.println(string+" "+map.get(string));
            }
        }
    }
}
