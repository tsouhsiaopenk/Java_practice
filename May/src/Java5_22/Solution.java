package Java5_22;

import java.util.Arrays;

public class Solution {
    // 调整数组顺序使奇数位于偶数前面
    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            // 从前方找偶数,是奇数的话就向右走
            while (left < right && nums[left] % 2 != 0){
                left++;
            }
            // 从后边找奇数，是偶数的话就想左走
            while (left < right && nums[right] % 2 == 0){
                right--;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,4};
        System.out.println(Arrays.toString(exchange(nums)));
    }
}
