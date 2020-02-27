import java.util.Scanner;

public class facbonacci {
    public static int fac(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fac(n - 1) + fac(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(fac(num));
    }
}
