package Java1_31;

import java.util.Arrays;

public class Solution {
    // 给定一个数组，将数组中的元素向右移动k个位置
    // 比如 [1,2,3,4,5,6,7] 和 k=3 ==》[5,6,7,1,2,3,4];
    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            // 最后一个元素
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    //给定一个数组 nums 和一个值 val ，你需要原地移除所有数值等于 val 的元素，
    // 返回移除后数组的新长度。
    //不要使用额外的数组空间，你必须在原地修改输入数组并在
    // 使用 O(1) 额外空间的条件下完成
    public int removeElement(int[] nums, int val) {
        // 特殊情况
        if (nums == null || nums.length == 0)
            return 0;
        // 将不被删除的元素用 index 重新排列
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    // 给定一个排序数组和一个目标值，
    // 在数组中找到目标值，并返回其索引。
    // 如果目标值不存在于数组中，返回它
    // 将会被按顺序插入的位置,你可以假设数组中无重复元素.
    public int searchInsert(int[] nums, int target) {
        // 若数组为空
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] > target) {
                return i;
            }
        }
        // 若都不成立，插入到最后
        return nums.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6};
        //solution.rotate(nums, 3);
        //int len = solution.removeElement(nums, 5);
        //System.out.println(len);
        System.out.println(solution.searchInsert(nums, 7));
        System.out.println(Arrays.toString(nums));

    }
}
