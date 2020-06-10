package Java6_8.OJ;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            String s = scanner.nextLine();
            String[] arr = s.split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int mul = multiple(a, b);
            System.out.println(mul);
        }
    }

    private static int multiple(int a, int b) {
        // 最大公约数
        int g = gcd(a, b);
        return a * b / g;
    }

    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
