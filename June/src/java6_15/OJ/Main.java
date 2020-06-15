package java6_15.OJ;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1.输入参数
        int N = scanner.nextInt();
        char c = scanner.next().charAt(0);
        // 2.绘制正方形
        drawSquare(N,c);
    }

    private static void drawSquare(int n, char c) {
        // 计算列数
        double x = 1.0*n/2;
        int row = (int)Math.round(x);
        // 打印第一行
        for (int i = 0; i < row; i++) {// 外层循环：行数
            for (int j = 0; j < n; j++) { // 内层循环：列数
                // 第一行和最后一行打印出所有的符号
                if (i == 0 || i == row -1){
                    System.out.print(c);
                }else{
                    // 其他的把第一个和最后一个打印出来，其他的是空格
                    if (j == 0 || j == n-1){
                        System.out.print(c);
                    }else {
                        System.out.print(" ");
                    }
                }

            }
            System.out.println();
        }
    }


}
