package Java6_20.Test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            // 读入数组长度
            int len = scanner.nextInt();
            // 创建数组
            int[] arr = new int[len];
            // 读入数组数据
            for (int i = 0; i < len; i++) {
                arr[i] = scanner.nextInt();
            }
            twoMimNum(arr);
        }
    }

    private static void twoMimNum(int[] nums) {
        // 1.先把所有结果都异或到一起
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        // 2.此时的结果相当于 a^b,值一定不为0,就可以从中找到某个为1的比特位
        int bit = 1;
        int i = 0;
        for (; i < 32; i++) {
            if ((ret & (bit << i)) != 0) {
                break;
            }
        }
        // 3.进行分组
        int a = 0;
        int b = 0;
        // 异或结果为1的位置处，a和b的该位置肯定不一样，这样就能分散在两组中进行计算
        for (int x : nums) {
            if ((x & (bit << i)) != 0) {
                a ^= x;
            } else {
                b ^= x;
            }
        }
        int[] arr = {a,b};
        Arrays.sort(arr);
        System.out.println(arr[0]+" "+arr[1]);
    }
}
