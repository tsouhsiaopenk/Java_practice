package Java4_21;

import java.util.*;

public class Solution {
    // 直接使用数组来写 f 函数
    public static int f(String s) {
        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                return hash[i];
            }
        }
        return -1;
    }
    // 使用 map 来写 f 函数
    public static int f2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        // 统计每个字符的个数 key 对应字符，value 对应出现次数
        for (char c : s.toCharArray()) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        // 找到最后字母
        ArrayList<Character> arrayList = new ArrayList<>(map.keySet());
        Collections.sort(arrayList);
        // 返回最小字母频次
        return map.get(arrayList.get(0));
    }
    /*
        题意就是queries里面每个单词从字典words中查找符合要求f(q) < f(w)的数量
        f()是计算字符串中最小字母个数 over
     */
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        // 先计算出 words 表中每个字符串的最小字母出现频次
        int[] fWords = new int[words.length];
        for (int i = 0; i < fWords.length; i++) {
            fWords[i] = f(words[i]);
        }
        int[] answer = new int[queries.length];
        // 遍历 queries 数组，在fWords中找 满足条件的个数赋值给 answer中
        for (int i = 0; i < queries.length ; i++) {
            int fq = f(queries[i]);
            answer[i] = helper(fWords,fq);
        }
        return answer;
    }

    private int helper(int[] fWords, int fq) {
        int count = 0;
        for (int i = 0; i < fWords.length; i++) {
            if (fWords[i] > fq){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "cccccccczzzz";
        System.out.println(f(s));
        System.out.println(f2(s));
    }
}
