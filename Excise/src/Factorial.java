import java.util.Scanner;

public class Factorial {
    // 阶乘
    public static int factor(int num){
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
    // 求1！+2！+3！+4！+........+n!的和
    public static int factorSum(int n){
        int result = 0;
        for(int i = 1;i<=n;i++){
            result+=factor(i);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(factorSum(num));
    }
}
