package Java7_21.review;

import java.util.Scanner;

/**
 * 计算日期倒天数的转换
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            int Day = outDay(year, month, day);
            System.out.println(Day);
        }
    }

    private static int outDay(int year, int month, int day) {
        // 定义数组，这里2月的天数取28，假设是平年
        int[] Day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 如果是闰年，将2月的天数修改为29
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            Day[1] = 29;
        }
        // 判断输入是否合法
        if (year <= 0 || month <= 0 || month > 12 || day <= 0 || day > Day[month - 1]) {
            return -1;
        }
        // 计算天数
        int sum = 0;
        for (int i = 0; i < month - 1; i++) {
            sum += Day[i];
        }
        return sum + day;
    }
}
