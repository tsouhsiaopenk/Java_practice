package Java7_3.OJ;

import java.util.Scanner;

// 年会抽奖
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();

            System.out.printf("%.2f%%",(1-1.0/n)*100);
        }
    }
}
