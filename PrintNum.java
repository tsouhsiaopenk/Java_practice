import java.util.Scanner;

public class PrintNum {
    public static void print(int num){
        // 将传入的整数转化为字符串
        String string = String.valueOf(num);
        // 将字符串转化为字符数组
        char[] data = string.toCharArray();
        // 利用for语句打印每一位
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num = scanner.nextInt();
        print(num);
    }
}
