package Java2_6;

import java.util.Arrays;

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        // 字符串转化为字符数组，因为字符串不能修改
        char[] chars = s.toCharArray();
        // 遍历一遍，将字符数组中的大写字母，转化为小写字母
        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        while (left < right) {
            // 如果左边既不是字母也不是数字的话，left++
            if (!Character.isLetter(chars[left]) && !Character.isDigit(chars[left])) {
                left++;
            }
            // 如果右边既不是字母也不是数字的话，right--
            else if (!Character.isLetter(chars[right]) && !Character.isDigit(chars[right])) {
                right--;
            } else if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //String s = "aA";
        // left = 15 right = 18  length = 29
        //System.out.println(solution.isPalindrome(s));
        //System.out.println(Arrays.toString(chars));

        double d = Math.cos(Math.toDegrees(42));
        System.out.println(d);
    }
}
