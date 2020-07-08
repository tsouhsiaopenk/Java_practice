package Java7_8.OJ;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String original = scanner.next().toUpperCase();
            String typedOut = scanner.next().toUpperCase();
            Set<Character> set = new LinkedHashSet<>();

            for (int i = 0; i < original.length(); i++) {
                Character c = original.charAt(i);
                if (!typedOut.contains(c+"")) {
                    set.add(c);
                }
            }
            for (Character c:set){
                System.out.print(c);
            }
        }
    }
}
