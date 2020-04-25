package Java4_25;

import java.util.Scanner;

public class Main {
    public static boolean isFibonacci(int N){
        //  遍历小于 N 的 fibonacci 数字，判断是否为 fibonacci数字
        for (int i = 1; fibonacci(i) <= N ; i++) {
            if (fibonacci(i) == N){
                return true;
            }
        }
        return false;
    }
    // 求出第n位的fibonacci数，n不能为0
    private static int fibonacci(int n){
        if (n == 1){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    int fab(int n){
        int temp1 = 1;
        int temp2 = 1;
        int result = 0;
        if (n == 1|| n == 2){
            return 1;
        }
        for (int i = 3; i <= n ; i++) {
            result = temp1+temp2;
            temp1 = temp2;
            temp2 = result;
        }
        return  result;
    }
    public static int step(int N){
        // 特殊情况
        if (isFibonacci(N)){
            return 0;
        }
        int upStep = 0;
        int downStep = 0;
        int cur1 = N;
        int cur2 = N;
        while (!isFibonacci(cur1)){
            cur1++;
            upStep++;
        }
        while (!isFibonacci(cur2)){
            cur2--;
            downStep++;
        }
        return Integer.min(upStep,downStep);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(step(N));
    }
}
