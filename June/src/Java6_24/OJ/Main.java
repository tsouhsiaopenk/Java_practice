package Java6_24.OJ;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            // 读入月数
            int month = scanner.nextInt();
            // 计算兔子数量
            int count = getTotalCount(month);
            // 输出兔子数量
            System.out.println(count);
        }
    }
    // 1 1 2 3 5 8 13 21 34
    private static int getTotalCount(int monthCount) {
        // 定义出三种年龄的兔子数量（初始情况下，只有一只兔子）
        // 年龄为 1 月的兔子数量
        int age1 = 1;
        // 年龄为 2 月的兔子数量
        int age2 = 0;
        // 年龄为 3 月及以上的兔子数量
        int age3 = 0;
        for (int i = 1; i < monthCount; i++) {
            // 3月的兔子及大于三岁的兔子在上一轮有的两岁，有的已经大于两岁
            age3 = age2 + age3;
            // 2月的兔子在上个月是1月的年龄
            age2 = age1;
            // 1月的兔子(特点：本月生的)是由三月的兔子生的
            age1 = age3;
        }
        // 兔子数量总和：一月的加二月的加三月的
        return age1 + age2 + age3;
    }
}
