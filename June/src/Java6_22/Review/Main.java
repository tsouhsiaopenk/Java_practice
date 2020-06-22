package Java6_22.Review;

import java.util.Scanner;

/**
 * 饥饿的小易
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x0 = scanner.nextLong();
        // 取模的值
        long m = 1_000_000_007;
        // 神秘力量使用的次数
        long s = 100_000;

        // f(X)=4x+3;
        long[] begin = new long[3];

        // 3次的取值
        begin[0] = x0;
        begin[1] = (4 * begin[0] + 3) % m;
        begin[2] = (4 * begin[1] + 3) % m;

        long minStep = s;
        long cur = 0;
        int step = 0; // 执行的步数
        for (int i = 0; i < 3; i++) {
            cur = begin[i];
            step = i;
            while (cur != 0 && step < minStep) {
                cur = (8 * cur + 7) % m;
                step++;
            }
            minStep = minStep < step ? minStep : step;
        }
        if (minStep < s){
            // 如果执行步数没有超过 s 输出最小步长
            System.out.println(minStep);
        }else {
            // 如果步数超过就返回 -1;
            System.out.println(-1);
        }
    }
}
