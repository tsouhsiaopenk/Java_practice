package Java3_24;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        //char[] chars = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char temp = string.charAt(i);
            if (!stringBuilder.toString().contains(temp + "")) {
                    stringBuilder.append(temp);
            }
        }

        System.out.println(stringBuilder);
    }
}
