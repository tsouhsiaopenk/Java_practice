package Java7_13.OJ;

import java.util.*;

/**
 * 木棒拼图
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            List<Integer> list = new LinkedList<>();
            // 操作数量
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                // 操作类型
                int operateType = scanner.nextInt();
                // 一个长度
                int L = scanner.nextInt();
                if (operateType == 1) {
                    // 在集合内插入一个长度为L的木棒
                    list.add(L);
                } else {
                    // 在集合中删除一个长度为L的木棒
                    list.remove(L);
                }
                isPolygon(list);
            }
        }
    }

    private static void isPolygon(List<Integer> list) {
        // 降序排序
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int max = list.get(0);
        int other = 0;
        for (Integer i : list) {
            other += i;
        }
        other = other-max;

        if (max >= other){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
    }
}
