package Java3_17;

public class Solution {
    // 实现方法 replace, 能够替换字符串中的某个部分
    public static String replace(String text, char oldChar, char newChar) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == oldChar) {
                chars[i] = newChar;
            }
        }
        return new String(chars);
    }


    public static boolean contains(String text,String pattern){
        // 父串每次后移一位
        for (int i = 0; i < text.length(); i++) {
            int cur = i;
            // 子串从当前父串的位置开始进行匹配
            for (int j = 0; j < pattern.length(); j++) {
                // 两个字符比较
                if (pattern.charAt(j) == text.charAt(cur)) {
                    if (j == (pattern.length() - 1) && text.charAt(cur) == pattern.charAt(j)) {
                        return true;
                    }
                    cur++;
                    continue;
                } else {
                    break;
                }
            }
        }
        return false;
    }

    // 比较两个字符串的大小（按照字典序）
    public static int compareTo(String str1,String str2){
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) > str2.charAt(j)){
                    return 1;
                }
                if (str1.charAt(i) < str2.charAt(j)){
                    return -1;
                }
                if (str1.charAt(i) == str2.charAt(j)){
                    continue;
                }
            }
        }
        if (str1.length()<str2.length()){
            return -1;
        }
        if (str1.length()>str2.length()){
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        String str1 = "西安科技大学计算机学院软件工程专业";
        String str2 = "西安科技大学";
        //System.out.println(str1.compareTo(str2));
        System.out.println(compareTo(str1,str2));
    }
}
