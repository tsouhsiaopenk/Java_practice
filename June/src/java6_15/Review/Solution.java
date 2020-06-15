package java6_15.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();
        char[] chars = N.toCharArray();
        List<Integer> list = new ArrayList<>();
        // 将list初始化 0- 9 均为 0
        for (int i = 0; i < 10; i++) {
            list.add(0);
        }
        // 进行累加
        for (int i = 0; i < chars.length; i++) {
            // 每次遇到一个数字就 + 1
            list.set(chars[i] - '0', list.get(chars[i] - '0') + 1);
        }
        // 打印输出
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                System.out.println(i + ":" + list.get(i));
            }
        }
    }
}
