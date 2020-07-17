package Java7_17.OJ;

import java.util.Scanner;

public class Solution {
    // 所有连续字串中最大的值
    static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            // 输入 n
            int n = scanner.nextInt();
            int[] arr = new int[n];
            // 输入数组
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            // 求最大字串的值
            maxSubString(arr);
            // 输出
            System.out.println(max);
            max = 0;
        }
    }

//    private static void maxSubString(int[] arr) {
//        int tmp = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j < arr.length; j++) {
//                tmp += arr[j];
//            }
//            if (max < tmp) {
//                max = tmp;
//            }
//            tmp = 0;
//        }
//    }


    private static void maxSubString(int[] arr) {
        int maxhere;
        max = maxhere = arr[0];   //初始化最大和为a【0】
        for (int i = 1; i < arr.length; i++) {
            //如果前面位置最大连续子序列和小于等于0，则以当前位置i结尾的最大连续子序列和为a[i]
            if (maxhere <= 0) {
                maxhere = arr[i];
            } else {//如果前面位置最大连续子序列和大于0，则以当前位置i结尾的最大连续子序列和为它们两者之和
                maxhere += arr[i];
            }
            //更新最大连续子序列和
            if (maxhere > max) {
                max = maxhere;
            }
        }
    }

}
