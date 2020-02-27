package Java1_31;

public class Soultion1 {
    //给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
    // 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
    // 如果可以构成，返回 true ；否则返回 false。
    //
    //(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)

    public boolean canConstruct(String ransomNote, String magazine) {
        // 1，用散列表统计出杂志中各个字母的个数
        int[] hash = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            hash[Integer.valueOf(magazine.charAt(i)) - 'a'] += 1;
        }
        // 2，若散列表中个数不够，返回false
        for (int i = 0; i < ransomNote.length(); i++) {
            hash[Integer.valueOf(ransomNote.charAt(i))-'a'] -=1;
            if(hash[(int) ransomNote.charAt(i) -'a']<0){
                return false;
            }
        }
        return true;
    }
}
