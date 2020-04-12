package Java4_12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    // 第一种： 排序 + 栈
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            stack.push(nums[i]);
        }
        while (!stack.isEmpty()) {
            int top1 = stack.pop();
            int top2 = 0;
            if (stack.isEmpty()) {
                return top1;
            } else {
                top2 = stack.pop();
            }
            if (top1 == top2) {
                continue;
            } else {
                return top1;
            }
        }
        return 0;
    }

    // 第二种：HashMap
    public int singleNumber1(int[] nums) {
        // 1.创建一个 Map 统计每个数字出现的次数，key 表示当前数字，value 表示数字
        Map<Integer, Integer> map = new HashMap<>();
        // 2.遍历数组，进行统计
        for (int x : nums) {
            Integer value = map.get(x);
            if (value == null) {
                // 如果这个数字在 map 中不存在，就增加一个键值对
                map.put(x, 1);
            } else {
                map.put(x, value + 1);
            }
        }
        // 3.遍历 map，找到出现次数为 1 次的数字
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue().equals(1)){
                return entry.getKey();
            }
        }
        // 4.如果输入为错误的话，就return 0; 理论上输入正确就不会触发这个语句
        return 0;
    }

    // 异或运算 a ^ b ^ b = a
    public int singleNumber2(int[] nums) {
        int ret = 0;
        for (int x:nums){
            ret ^= x;
        }
        return ret;
    }
}
