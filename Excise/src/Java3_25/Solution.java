package Java3_25;

public class Solution {
    public int strStr(String haystack, String needle) {
        // 特殊情况
        if (!haystack.equals("") && needle.equals("")) {
            return 0;
        }
        if (haystack.equals("") && needle.equals("")) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int cur = i;
            // 子串从当前父串的位置开始进行匹配
            for (int j = 0; j < needle.length(); j++) {
                // 两个字符比较
                if (needle.charAt(j) == haystack.charAt(cur)) {
                    if (j == (needle.length() - 1) && haystack.charAt(cur) == needle.charAt(j)) {
                        return i;
                    }
                    cur++;
                    continue;
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String text = "mississippi";
        String pattern = "ssipi";
        int result = solution.strStr(text,pattern);
        System.out.println(result);
    }
}
