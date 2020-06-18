package Java6_18.review;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            String addend = scanner.next();
            String augend = scanner.next();
            BigInteger num1 = new BigInteger(addend);
            BigInteger num2 = new BigInteger(augend);
            System.out.println(num1.add(num2));
        }
    }
}
