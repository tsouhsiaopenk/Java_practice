package Java4_25;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String string = in.nextLine();
            String[] strings = string.split(" ");
            for (String s:strings){
                set.add(s);
            }
        }
        System.out.println(set.size());
    }
}
