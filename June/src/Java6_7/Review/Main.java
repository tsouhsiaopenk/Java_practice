package Java6_7.Review;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println(count(n));
        }
    }

    private static int count(int n) {
        // 合法性校验(小于等于 10以下的数字中只有6和8可以，大于10以上的只要是偶数就可以)
        if (n % 2 != 0 || (n < 12 && (n != 6 && n != 8))) {
            return -1;
        }
        // 八个正好拿完
        if (n % 8 == 0) {
            return n / 8;
        }
        // 不能正好拿完，就把前面的 8 个的袋子换成 6 个的
        return 1 + n / 8;
    }
}
