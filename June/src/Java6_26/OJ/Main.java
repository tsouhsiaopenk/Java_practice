package Java6_26.OJ;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            // 输入 N 的个数
            int N = scanner.nextInt();
            // 定义一个存放数据的数组
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            getA1(arr);
            getA2(arr);
            getA3(arr);
            getA4(arr);
            getA5(arr);
        }
    }

    private static void getA5(int[] arr) {
        int A5 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 4) {
                A5 = Math.max(A5, arr[i]);
            }
        }
        if (A5 == 0) {
            System.out.print("N");
        } else {
            System.out.print(A5);
        }
    }
    // 能被5整除余三的数字的平均数
    private static void getA4(int[] arr) {
        // 和
        int sum = 0;
        // 个数
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 3) {
                sum += arr[i];
                count++;
            }
        }
        double A4 =  (double) sum / count;
        if (sum != 0) {
            // 此处需要精确到小数点后一位
            System.out.printf("%.1f ",A4);
        } else {
            System.out.print("N" + " ");
        }
    }

    private static void getA3(int[] arr) {
        int A3 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 2) {
                A3++;
            }
        }
        if (A3 == 0) {
            System.out.print("N" + " ");
        } else {
            System.out.print(A3 + " ");
        }
    }

    // A2为能被5除后余1的数字按照给出顺序进行交错求和
    private static void getA2(int[] arr) {
        int A2 = 0;
        // 是否做减法
        int isSub = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%5 == 1){
                A2 += isSub*arr[i];
                isSub=-isSub;
            }
        }
        if (A2 == 0) {
            System.out.print("N" + " ");
        } else {
            System.out.print(A2 + " ");
        }
    }

    // A1 为能被5整除的数字中所有偶数的和
    private static void getA1(int[] arr) {
        int A1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 0 && arr[i] % 2 == 0) {
                A1 += arr[i];
            }
        }
        if (A1 == 0) {
            System.out.print("N" + " ");
        } else {
            System.out.print(A1 + " ");
        }
    }
}
