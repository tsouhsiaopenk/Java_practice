package Java2_1;

import java.util.Arrays;

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // end 为最后一个字符的小标，若最后没有空格，直接为长度-1
        int end = s.length() - 1;
        // 若最后一个字符为空格，end，就向前减1
        while (s.charAt(end) == ' ' && end >= 0) {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        // start 为最后一个单词的开始下标
        int start = end;
        while (s.charAt(start) != ' ' && start >= 0) {
            start--;
        }
        return end - start;
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] newArray = new int[m + n];
        for (int i = 0, pointer1 = 0, pointer2 = 0; i < m + n; i++) {
            if (pointer1 < m || pointer2 < n) {
                if (nums1[pointer1] < nums2[pointer2]) {
                    newArray[i] = nums1[pointer1++];
                }
                if (nums1[pointer1] > nums2[pointer2]) {
                    newArray[i] = nums2[pointer2++];
                }
                if (nums1[pointer1] == nums2[pointer2]) {
                    newArray[i++] = nums1[pointer1++];
                    newArray[i] = nums2[pointer2++];
                }
            } else {
                // 如果数组nums1已经取完，数组nums2还没有取完的话，就直接取数组nums2中的元素
                if (pointer1 >= m && pointer2 < n) {
                    newArray[i] = nums2[pointer2++];
                }
                // 如果数组nums2已经取完，数组nums1还没有取完的话，就直接取数组nums1中的元素
                if (pointer2 >= n && pointer1 < m) {
                    newArray[i] = nums1[pointer1++];
                }
            }
        }
        nums1 = newArray;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n){
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
