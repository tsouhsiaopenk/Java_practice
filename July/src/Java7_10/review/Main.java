package Java7_10.review;

import java.util.Scanner;

/**
 * 霍格沃兹找零钱：
 * 进制转换问题；可以堪称特殊进制的数，统一转换为最小单位后计算
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strP = scanner.next().split("\\.");
        String[] strA = scanner.next().split("\\.");
        // 将字符串转换为数值类型，考虑到可能过大，用 long 类型
        long[] longP = {
                Long.parseLong(strP[0]),
                Long.parseLong(strP[1]),
                Long.parseLong(strP[2]),
        };
        long[] longA = {
                Long.parseLong(strA[0]),
                Long.parseLong(strA[1]),
                Long.parseLong(strA[2]),
        };
        // 将单位全部转化为 纳特（Knut）
        long pInKnut = toKnut(longP[0],longP[1],longP[2]);
        long aInKnut = toKnut(longA[0],longA[1],longA[2]);
        long changeInKnut = aInKnut - pInKnut;
        if (changeInKnut < 0){
            System.out.print("-");
            changeInKnut = -changeInKnut;
        }
        // 打印时，将单位还原回去
        System.out.format("%d.%d.%d\n",
                changeInKnut/(17*29),
                (changeInKnut%(17*29))/29,
                // changeInKnut/29%17,
                ((changeInKnut % (17*29)) % 29)
        );
    }

    private static long toKnut(long galleon, long sickle, long Knut) {
        return galleon * 17 * 29 + sickle * 29 + Knut;
    }
}
