package Java6_4.OJ;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 一次性通过，加油
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String first = scanner.nextLine();
            String second = scanner.nextLine();
            String result = modifiedString(first, second);
            System.out.println(result);
        }
    }

    private static String modifiedString(String first, String second) {
        Set<Character> exclusive = new HashSet<>();
        for (Character c : second.toCharArray()) {
            exclusive.add(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : first.toCharArray()) {
            if (!exclusive.contains(c)) {
                stringBuilder.append(c);
            }
        }
        return new String(stringBuilder);
    }
}
