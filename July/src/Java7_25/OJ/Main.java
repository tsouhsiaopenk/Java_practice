package Java7_25.OJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 查找兄弟单词：
 *  兄弟单词：两个单词不同，长度相同，但是构成的字母顺序不相同
 *  输入描述：先输入字典中单词的个数n，再输入n个单词作为字典单词。
 *          再输入一个单词，查找其在字典中兄弟单词的个数m再输入数字k
 *
 *  输出描述：根据输入，输出查找到兄弟单词的个数m，然后输出查找到的兄弟单词的第k个单词。
 *            注意：一定要关注最终返回的第 k 个单词这样的序号，不能搞错。
 *  解题思路：
 *      1.将字典中的单词先放到集合中
 *      2.对集合进行排序
 *      3.isBrother 函数依次判定每个输入的单词是否是兄弟单词
 *      4.判定兄弟单词的规则是
 *          1.先判定长度
 *          2.如果长度相同，再看是否是完全相同（完全相同不是兄弟）
 *          3.然后将两个单词排序，排序相同才是真兄弟单词
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            // 输入
            int n = scanner.nextInt();
            String[] s = new String[n];
            for (int i = 0; i < n; i++) {
                s[i] = scanner.next();
            }
            // 查找该单词的兄弟单词个数
            String key = scanner.next();
            // 查找第k个兄弟单词
            int k = scanner.nextInt();

            int count = 0;
            char[] keyChar = key.toCharArray();
            Arrays.sort(keyChar);

            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                int c = check(key,s[i],keyChar);
                count += c;
                if (c == 1){ // 如果是兄弟单词，就添加对集合中
                    list.add(s[i]);
                }
            }
            System.out.println(count);

            // 排序，保证字典序
            Collections.sort(list);
            if (count >= k){
                System.out.println(list.get(k -1));
            }
        }
    }

    private static int check(String key, String word, char[] keyChar) {
        // 就是将这两个单词按字符排序后看相不相同
        if (key.equals(word) || key.length() != word.length()){
            return 0;
        }
        char[] wordChar = word.toCharArray();
        Arrays.sort(wordChar);
        // 上边已经保证了长度一致，这里只要两者的单词序列一致就说明
        // 两者就是兄弟单词。
        return Arrays.equals(keyChar,wordChar) ? 1 : 0;
    }
}
