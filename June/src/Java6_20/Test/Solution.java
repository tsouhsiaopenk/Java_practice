package Java6_20.Test;

import java.util.Scanner;

public class Solution {
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
            OutputLR(arr);
        }
    }

    private static void OutputLR(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int L = -1;
            int R = -1;
            // i 位置的左边找符合要求的值L
            int left = i - 1;
            int right = i + 1;
            while (left >= 0){
                if (arr[left] < arr[i]){
                    L = left;
                    break;
                }
                left--;
            }
            while (right < arr.length){
                if (arr[right] < arr[i]){
                    R = right;
                    break;
                }
                right++;
            }
            System.out.println(L + " " + R);
        }
    }
}

