package Java4_14;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BrokenKeyBoard {
    /*
        旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。
        现在给出应该输入的一段文字、以及实际被输入的文字，请你列出肯定坏掉的那些键。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 测试数据多组
        while(scanner.hasNext()){
            // 想得到的字符串
            String expected = scanner.next();
            // 实际得到的字符换
            String actual = scanner.next();
            // 把读入的字符串转化为大写
            expected = expected.toUpperCase();
            actual = actual.toUpperCase();
            // 保存实际输出的字符到 actualSet 中
            Set<Character> actualSet = new HashSet<>();
            for (char c : actual.toCharArray()){
                actualSet.add(c);
            }
            // 已经输出的字符放在 brokenKeySet 中
            Set<Character> brokenKeySet = new HashSet<>();
            for (char c: expected.toCharArray()) {
                if (actualSet.contains(c)){
                    continue;
                }
                if (brokenKeySet.contains(c)){
                    continue;
                }
                System.out.print(c);
                brokenKeySet.add(c);
            }
        }

    }
}
