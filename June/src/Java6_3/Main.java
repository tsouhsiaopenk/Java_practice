package Java6_3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            // 传进来空瓶子数目
            int emptyBottleNumber = scanner.nextInt();
            // 输出最多可以兑换的汽水数目
            System.out.println(maxSodaNumber(emptyBottleNumber));
        }
    }

    private static int maxSodaNumber(int emptyBottleNumber) {
        // 特殊情况一：瓶子数量小于二的话，就换不到汽水
        if (emptyBottleNumber < 2) {
            return 0;
        }
        // 特殊情况二：瓶子数量为二的话，刚好可以换到一瓶
        if (emptyBottleNumber == 2) {
            return 1;
        }
        // 最后返回的结果
        int count = 0;
        // 当前有的瓶子可以换到的汽水数
        int currentChange = emptyBottleNumber / 3;
        count = count + currentChange;
        // 剩余瓶子数
        int remainBottles = emptyBottleNumber % 3;
        count = count + maxSodaNumber(currentChange + remainBottles);
        return count;
    }
}
