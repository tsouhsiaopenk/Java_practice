package Java6_16.OJ;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        while (scanner.hasNextInt()) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i = 1; i < 10; i++) {
                for (int j = 0; j < arr[i]; j++) {
                    System.out.print(i);
                    // 已经打印出了第一个数字
                    if (i == 1 && j == 0) {
                        for (int k = 0; k < arr[0]; k++) {
                            System.out.print(0);
                        }
                    }
                }
            }
        }
    }
}
