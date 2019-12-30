import java.util.Scanner;

public class BinaryNum {
    /**
        获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(Integer.toBinaryString(num));
        // 打印偶数
        System.out.println("偶数序列：");
        for (int i = 31; i >=1; i-=2) {
            System.out.print(((num>>i)&1)+" ");
        }
        System.out.println();
        System.out.println("奇数序列：");
        // 打印奇数
        for (int i = 30;i>=0; i-=2){
            System.out.print(((num>>i)&1)+" ");
        }
    }
}
