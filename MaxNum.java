import java.util.Scanner;

public class MaxNum {
    // 返回两个数字中最大的值
    public static int max2(int a,int b){
        return a > b ? a : b;
    }
    // 返回三个数字中的最大的值
    public static int max3(int a,int b,int c){
        int max1 = max2(a,b);
        int max2 = max2(max1,c);
        return max2;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println("a,b中的最大值为："+max2(a,b));
        System.out.println("a,b,c中的最大值为:"+max3(a,b,c));
    }
}
