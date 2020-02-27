package Java2_4;

import java.util.Arrays;

class Solution {
    // 偶数，奇数
    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            // 如果左边为奇数，右边为偶数，进行交换
            if (A[left] % 2 != 0 && A[right] % 2 == 0) {
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                left++;
                right--;
                continue;
            }
            // 如果左、右边均为偶数
            if (A[left] % 2 == 0 && A[right] % 2 == 0) {
                left++;
            }
            // 如果左右均为奇数
            if (A[left] % 2 != 0 && A[right] % 2 != 0) {
                right--;
            }
        }
        return A;
    }

    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0, leftSum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] == leftSum * 2) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }
        return -1;
    }

    public int[] plusOne(int[] digits) {
//        // 将 数组转化为字符串
//        String str = String.valueOf(digits);
//        // 字符串转化为整数
//        int num = Integer.valueOf(str);
//        // 整数加1
//        num++;
//        // 整数转化为字符串
//        str = String.valueOf(num);
//        // 字符串转化为整形数组
//        for (int i = 0; i < str.length(); i++) {
//            digits[i] = Integer.valueOf(str.charAt(i));
//        }
//        return digits;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] tmp = new int[digits.length + 1];
        tmp[0] = 1;
        return tmp;
    }

    public int thirdMax(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        // 三个数字是否改变的编制
        int step = 0;
        boolean f = true;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == Integer.MIN_VALUE && f){
                step++;
                f = false;
            }
            if (firstMax < nums[i]) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
                step++;
            } else if (firstMax > nums[i] && secondMax < nums[i]) {
                thirdMax = secondMax;
                secondMax = nums[i];
                step++;
            } else if (secondMax > nums[i] && thirdMax < nums[i]) {
                thirdMax = nums[i];
                step++;
            }
        }
        if (step>=3){
            return thirdMax;
        }
        return firstMax;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2, 2, 5,3,5};
        System.out.println(Arrays.toString(nums));
        System.out.println(solution.thirdMax(nums));
    }
}
