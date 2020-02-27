package Java2_5;

import java.math.BigInteger;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    arr[0] = nums[i];
                    arr[1] = nums[j];
                }
            }
        }
        return arr;
    }

    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        // 是否进一位
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            // 获取字符串a对应的某一位的值 当i<0时候 sum+=0(向前补0) 否则取原值
            sum += (i >= 0 ? a.charAt(i) - '0' : 0);
            // 过去字符串a对应的某一位的值 当i<0时候
            sum += (j >= 0 ? b.charAt(j) - '0' : 0);
            // 如果二者均为1 那么sum%2应该刚好等于0，否则为0
            ans.append(sum % 2);
            // 如果二者均为1 那么ca应该刚好为1，否则为0
            ca = sum / 2;
        }
        // 判断最后一次是否有进位
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

    public int myAtoi(String str) {
        // 若为空字符串
        if (str.length() == 0) {
            return 0;
        }

        str.trim();
        System.out.println(str);
        int num = Integer.parseInt(str);
        System.out.println(num);
        return num;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] arr = {-1, -1};
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && flag == false) {
                arr[0] = i;
                flag = true;
            }
            if (nums[i] == target && flag == true) {
                arr[1] = i;
            }
        }
        return arr;
    }



    public static void main(String[] args) {

    }
}
