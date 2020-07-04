package Java7_4.OJ;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            BigInteger[] arr = new BigInteger[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextBigInteger();
            }
            // 冒泡排序 : 从小到大进行升序排序
            for (int bound = 0; bound < N; bound++) {
                for (int cur = N - 1; cur > bound; cur--) {
                    // arr[cur] < arr[cur-1]
                    if (arr[cur].compareTo(arr[cur - 1]) < 0) {
                        BigInteger tmp = arr[cur];
                        arr[cur] = arr[cur-1];
                        arr[cur-1] = tmp;
                    }
                }
            }
            // 输出数组中元素
            for (int i = 0; i < N; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    @Test
    public void test() {
        BigInteger a = new BigInteger("12345567788934567876534");
        BigInteger b = new BigInteger("23456789876345678");
        BigInteger tmp = a;
        a = b;
        b = tmp;
        System.out.println(a);
        //System.out.println(b);
    }
}
