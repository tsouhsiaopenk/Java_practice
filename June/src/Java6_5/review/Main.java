package Java6_5.review;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(drink(n));
        }
    }

    private static int drink(int n) {
        // 材料总数
        int total = 0;
        while (n > 2) {
            total = total + n / 3;
            // 新的空瓶子数目
            n = n / 3 + n % 3;
        }
        if (n == 2) {
            total++;
        }
        return total;
    }
}
