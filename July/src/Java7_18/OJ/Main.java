package Java7_18.OJ;

import java.util.Scanner;

/**
 * 计算日期到天数转换
 */
class Date {
    int year;
    int month;
    int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    static int[] leap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] nonleap = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public boolean isLegal() {
        // 月份非法
        if (this.month < 1 || this.month > 12) {
            return false;
        }
        // 日期非法
        if (isLeap(year)) {
            // 闰年
            if (leap[month - 1] < day) {
                return false;
            }
        } else {
            // 平年
            if (nonleap[month - 1] < day) {
                return false;
            }
        }
        return true;
    }

    // 是否为闰年
    private boolean isLeap(int year) {
        // 普通闰年
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        // 世纪闰年
        if (year % 400 == 0) {
            return true;
        }
        return false;
    }

    // 返回天数
    public int getOutDay() {
        boolean flag = isLeap(year);
        int sum = 0;
        if (flag) {
            // 如果是闰年
            for (int i = 0; i < month - 1; i++) {
                sum += leap[i];
            }
        } else {
            // 如果是平年
            for (int i = 0; i < month - 1; i++) {
                sum += leap[i];
            }
        }
        sum += day;
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            // 输入年月日
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            Date date = new Date(year, month, day);
            boolean state = date.isLegal();
            if (state) {
                int res = date.getOutDay();
                System.out.println(res);
            } else {
                System.out.println(-1);
            }
        }
    }
}
