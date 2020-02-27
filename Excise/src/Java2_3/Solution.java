package Java2_3;

import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) {
            return false;
        }
        int left = 0;
        for (int i = 0; i < typed.length(); i++) {
            if (name.charAt(left) == typed.charAt(i)) {
                left += 1;
            }
            if (left == name.length()) {
                return true;
            }
        }
        return false;
    }

    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public String reverseOnlyLetters(String S) {
        // 将字符串转化为数组进行处理
        char[] arr = S.toCharArray();
        // 定义两个变量记录左右两边的字母下标
        int left = 0;
        int right = arr.length-1;
        // 在循环中交换字母
        while (left < right) {
            // 如果左右均为字母，进行交换
            if (isLetter(arr[left])==true && isLetter(arr[right])==true) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                right--;
                left++;
                continue;
            }
            // 如果右侧不是字母，右侧变量right--
            if (!isLetter(arr[right])) {
                right--;
            }
            // 如果左侧不是字母，左侧变量left++
            if (!isLetter(arr[left])) {
                left++;
            }
        }
        return new String(arr);
    }

    private boolean isLetter(char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "ab-cd";
        Solution solution = new Solution();
        System.out.println(solution.reverseOnlyLetters(str));
    }
}
