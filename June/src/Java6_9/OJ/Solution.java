package Java6_9.OJ;

import java.util.Scanner;

/**
 * 删数
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n > 1000) {
                n = 1000;
            }
            int lastIndex = func(n);
            System.out.println(lastIndex);
        }
    }

    private static int func(int n) {
        // 根据题意，先把所需要的数组构造出来
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        // 设置一个计数器。记录已经删除的个数，若删除个数为 n - 1,就说明已经找到最后一个元素的下标
        int count = 0;
        // 设置一个游标：每加两次删除一个数字
        int cur = 0;
        // 设置一个当前下标记录数据
        int currentIndex = 0;
        // 如果计数器没有达到n就说明数数组中的元素没有删除完
        while (count < n) {
            // 每经过一个数字，游标加一
            cur++;
            if (cur == 2) {
                // 该删除的地方：删除完了之后，当前下标向后移动一个位置
                cur = 0;
                // 逻辑删除，将该下标处置为-1
                arr[currentIndex] = -1;
                // 删除的个数加一
                count++;
                // 当前下标向后移动一个位置
                currentIndex = (currentIndex + 1) % arr.length;
            }
            // 当前下标加一
            while (arr[currentIndex] == -1) {
                currentIndex = (currentIndex + 1) % arr.length;
            }
        }
        return currentIndex;
    }
}

