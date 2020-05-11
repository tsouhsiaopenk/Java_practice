package Java5_11;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            deduplication(scanner.nextLine());
        }
    }
    private static void deduplication(String s){
        HashSet<Character> set = new HashSet();
        for(int  i = 0;i < s.length();i++){
            if (set.contains(s.charAt(i))){
                continue;
            }
            set.add(s.charAt(i));
            System.out.print(s.charAt(i));
        }
        set.clear();
    }
}
