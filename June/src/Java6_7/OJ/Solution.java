package Java6_7.OJ;

import java.util.Scanner;

public class Solution {
    /*
        思路：直接利用数学知识来解题（看作方程）
        四个方程式三个未知数，用三个来计算，一个来验证
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            String[] strings = string.split(" ");
            int[] arr = new int[4];
            for (int i = 0; i < 4; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }
            int A = 0;
            int B = 0;
            int C = 0;
            A = (arr[0] + arr[2]) / 2;
            B = (arr[1] + arr[3]) / 2;
            C = (arr[2] + arr[3]) - A - 2 * B;
            int tmp = A - (arr[0]+ arr[1]);
            if (A >= 0 && B >= 0 && C >= 0 && C == tmp){
                System.out.println(A + " " + B + " "+ C);
            } else {
                System.out.println("No");
            }

        }
    }
}
