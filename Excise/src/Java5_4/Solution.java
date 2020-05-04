package Java5_4;

public class Solution {
    public  String reverseOnlyLetters(String S) {
        // 1.把字符串转为字符数组，进行修改
        char[] chars = S.toCharArray();
        // 2.遍历数组进行交换
        int left = 0;
        int right = S.length() - 1;
        while (left < right) {
            // 找到左起的第一个字母
            while (!Character.isLetter(chars[left]) && left < right){
                left++;
            }
            // 找到右起的第一个字母
            while (!Character.isLetter(chars[right]) && left < right){
                right--;
            }
            // 交换
            swap(chars,left,right);
            left++;
            right--;
        }
        // 3.将字符数组转化为字符串
        return new String(chars);
    }

    private void swap(char[] chars, int left, int right) {
        char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
    }

//    public int ascii(char c) {
//        return c;
//    }
//
//    public boolean isLetter(char c) {
//        int asc = ascii(c);
//        // 大写字母
//        if (65 <= asc && asc <= 90) {
//            return true;
//        }
//        if (97 <= asc && asc <= 122) {
//            return true;
//        }
//        return false;
//    }

    public static void main(String[] args) {
        String s = "ab-cd";
        Solution solution = new Solution();
        System.out.println(solution.reverseOnlyLetters(s));
    }
}
