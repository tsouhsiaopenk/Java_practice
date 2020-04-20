package Java4_20;


import javax.print.DocFlavor;
import java.util.*;

public class Solution {
    // t 多一个字母
    public char findTheDifference(String s, String t) {
        // 字符串转数组
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        // 排序
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        // 依次比较
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) {
                // 这里返回的是 tChars 中的字母
                return tChars[i];
            }
        }
        return tChars[tChars.length - 1];
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 排除特殊情况，如果数组中的元素不够两个 或者k值小于1就返回false
        if (nums.length < 2 || k < 1) {
            return false;
        }
        // 创建一个能放 k 个元素的 set
        HashSet<Integer> set = new HashSet<>(k);
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素包含在 长度为k的set中，说明正确
            if (set.contains(nums[i])) {
                return true;
            } else {
                // 删除 set 中前面的元素
                if (i > k - 1) {
                    set.remove(nums[i - k]);
                }
                // 将新的元素添加进 set 中
                set.add(nums[i]);
            }
        }
        return false;
    }


    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> bannedSet = new HashSet<>();
        for (String word:banned){
            bannedSet.add(word);
        }
        HashMap<String,Integer> count = new HashMap<>();
        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()){
            if (Character.isLetter(c)){
                word.append(Character.toLowerCase(c));
            }else if (word.length() > 0){
                String finalword = word.toString();
                if (!bannedSet.contains(finalword)){
                    count.put(finalword,count.getOrDefault(finalword,0)+1);
                    if (count.get(finalword) > ansfreq){
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 1};
        boolean b = containsDuplicate(num);
        System.out.println(b);
    }

}
