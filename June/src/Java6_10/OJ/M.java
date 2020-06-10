package Java6_10.OJ;

import java.util.Scanner;

public class M {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            StringBuilder stringBuilder = new StringBuilder(s);
            stringBuilder.reverse();
            System.out.println(stringBuilder.toString());
        }
    }
}
