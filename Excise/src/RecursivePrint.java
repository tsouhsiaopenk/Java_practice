import java.util.Enumeration;

public class RecursivePrint {
    /**
     * 按顺序打印一个数字的每一位
     * (例如 1234 打印出 1 2 3 4) （递归）
     * @param n
     * @return
     */
    public static void print(int n){
        // n大于9就一直除以10，最后得到最高位
        if (n>9){
            print(n /10);
        }
        // 把除过最后一位之外的数字去掉
        System.out.print(n%10 +" ");
    }
    /*
    1 2 3 4
    1 2 3
    1 2
    1
     */

    public static void main(String[] args) {
        print(1234);
    }
}
