package Java7_16.OJ;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 输入两个字符串
            String first = scanner.nextLine();
            String second = scanner.nextLine();
            // 在first中删除出现在second中的字母
            Set<Character> set = new HashSet<>();
            for(Character c:second.toCharArray()){
                set.add(c);
            }
            for(Character c:first.toCharArray()){
                if(!set.contains(c)){
                    System.out.print(c);
                }
            }
        }
    }
}