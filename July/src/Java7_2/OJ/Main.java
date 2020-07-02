package Java7_2.OJ;

import java.util.Scanner;

public class Main {
    // 判断是否为守形数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int N = scanner.nextInt();
            int square = (int)Math.pow(N,2);
            // 将N转换为字符串
            String sN = String.valueOf(N);
            // 将square转换为字符串
            String sSquare = String.valueOf(square);
            if (sSquare.endsWith(sN)){
                System.out.println("Yes!");
            }else {
                System.out.println("No!");
            }
        }
    }
}
