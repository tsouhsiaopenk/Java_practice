package Java7_20.review;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 删除公共字符
 */
public class Main {
    public static String DeleteChars(String str1,String str2){
        if (str1 == null || str2 == null){
            return null;
        }
        // 数组大小为256，因为字符最多256个
        boolean[] hashtable = new boolean[256];
        // 将 str2中字符对应的hashtable数组中的位置上的值设为true
        for (int i = 0; i < str2.length(); i++) {
            int index = str2.charAt(i);
            hashtable[index] = true;
        }
        char[] str1s = str1.toCharArray();
        int j = 0;
        // 开始遍历str1，没有出啊先过的字符，覆盖掉出现过的
        for (int i = 0; i < str1s.length; i++) {
            int index = str1s[i];
            if (!hashtable[index]){
                str1s[j++] = str1s[i];
            }
        }
        // 不进行重新拷贝的话，打印结果会包含原有部分数据
        str1s = Arrays.copyOf(str1s,j);
        return String.copyValueOf(str1s);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            String str = DeleteChars(s1,s2);
            System.out.println(str);
        }
    }
}
