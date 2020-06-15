package java6_15.OJ;


import org.junit.Test;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String addend = scanner.next();
            String augend = scanner.next();
            System.out.println(AddLongInteger(addend,augend));
        }
    }
    /*
        算法：完成两个超长正整数的加法
     */
    public static String AddLongInteger(String addend, String augend) {
        // 结果
        StringBuilder res = new StringBuilder();
        // 将加数和被加数进行反转
        StringBuilder add = new StringBuilder(addend).reverse();
        StringBuilder aug = new StringBuilder(augend).reverse();
        // 求出长度
        int addLength = add.length();
        int augLength = aug.length();
        int maxLen = Math.max(addLength, augLength);
        // 用 0 补全字符串使得一样长
        while (addLength <= maxLen) {
            add.append('0');
            addLength++;
        }
        while (augLength <= maxLen) {
            aug.append('0');
            augLength++;
        }
        // 进位
        int carryBit = 0;
        // 当前位
        int current = 0;
        for (int i = 0; i < maxLen; i++) {
            int ad = add.charAt(i) - '0';
            int au = aug.charAt(i) - '0';
            int sum = ad + au + carryBit;
            current = sum >= 10 ? sum - 10 : sum;
            carryBit = sum / 10;
            res.append(current);
        }
        if (carryBit != 0) {
            res.append(1);
        }
        return res.reverse().toString();
    }

    @Test
    public void test() {
        String s1 = "99999999999999999999999999999999999999999999999999";
        String s2 = "1";
        String s = AddLongInteger(s1, s2);
        System.out.println(s);
    }

    @Test
    public void t() {
        System.out.println(10 / 10);


    }
}
