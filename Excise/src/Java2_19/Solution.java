package Java2_19;

import java.util.Stack;

/*
        [2, 6, 4, 8, 10, 9, 15]         输出: 5
        从左到右循环，记录最大值为 max，若 nums[i] < max,
        则表明位置 i 需要调整, 循环结束，
        记录需要调整的最大位置 i 为 high;
        同理，从右到左循环，记录最小值为 min,
        若 nums[i] > min, 则表明位置 i 需要调整，
        循环结束，记录需要调整的最小位置 i 为 low.
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[len - 1];
        int left = 0;
        int right = -1;
        for (int i = 0; i < len; i++) {
            // 确定左边界
            if (max > nums[i]) {
                right = i;
            } else {
                max = nums[i];
            }
            // 确定右边界
            if (min < nums[len - 1 - i]) {
                left = len - 1 - i;
            } else {
                min = nums[len - 1 - i];
            }
        }
        // 左右边界的闭区间 [left,right]->right-left+1
        return right - left + 1;
    }
    public int evalRPN(String[] tokens) {
//        Stack<Integer> stack = new Stack<>();
//        for (String s:tokens) {
//            if (s.equals("+")){
//                stack.push(stack.pop()+stack.pop());
//            }else if (s.equals("-")){
//                stack.push(-stack.pop()+stack.pop());
//            }else if (s.equals("*")){
//                stack.push(stack.pop()*stack.pop());
//            }else if (s.equals("/")){
//                int num = stack.pop();
//                stack.push(stack.pop()/num);
//            }else{
//                stack.push(Integer.parseInt(s));
//            }
//
//       return stack.pop();
        Stack<Integer> stack = new Stack<>();
        for (String s:tokens) {
            switch (s){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop()+stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    int num = stack.pop();
                    stack.push(stack.pop()/num);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        int  [] nums = {2, 6, 4, 8, 10, 9, 15};
        Solution solution = new Solution();
        int result = solution.findUnsortedSubarray(nums);
        System.out.println(result);
    }
}
