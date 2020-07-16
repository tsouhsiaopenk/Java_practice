package Java7_16.OJ;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String sentence = scanner.nextLine();
            String reverseSentence = reverse(sentence);
            System.out.println(reverseSentence);
        }
    }

    private static String reverse(String sentence) {
        // 按照空格进行划分
        String[] str = sentence.split(" ");
        // 利用 StringBuilder 进行拼接字符串
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String s : str) {
            stack.push(s);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        // 删除最后多余的空格
        sb.deleteCharAt(sb.length() - 1);
        // 返回字符串
        return sb.toString();
    }
}
