package Jav6_30.OJ;

import org.junit.Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int sum = calculateSum(n);
            int squareSum = calculateSum(n * n);
            System.out.println(sum + " " + squareSum);
        }
    }
    // 此时顺利通过
    private static int calculateSum(int n) {
        int sum = 0;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - 48;
        }
        return sum;
    }
    // 通过率 30%，可能是效率的问题
//    private static int calculateSum(int n) {
//        int sum = 0;
//        while (n % 10 != 0) {
//            sum += n % 10;
//            n = n / 10;
//        }
//        return sum;
//    }

    @Test
    public void test(){
        /*
        4
        12
        97
        39999
         */
        System.out.println(calculateSum(4));
        System.out.println(calculateSum(12));
        System.out.println(calculateSum(97));
        System.out.println(calculateSum(39999));
//        char c = '1';
//        System.out.println(c+0);
    }
}
