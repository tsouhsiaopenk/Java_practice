package Java4_14;

import java.util.Stack;

public class CalPoints {
    /*
        给定一个字符串列表，每个字符串可以是以下四种类型之一：
        1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
        2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
        3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
        4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
     */
    public int calPoints1(String[] ops) {
        int[] arr = new int[ops.length];
        int i = 0;
        for (String s : ops) {
            switch (s) {
                case "+": {
                    arr[i] = arr[i - 1] + arr[i - 2];
                    i++;
                    break;
                }
                case "D": {
                    arr[i] = 2 * arr[i - 1];
                    i++;
                    break;
                }
                case "C": {
                    arr[i] = 0;
                    i--;
                    break;
                }
                default: {
                    arr[i] = Integer.valueOf(s);
                    i++;
                }
            }
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String s:ops){
            switch (s){
                case "+":{
                    int top = stack.pop();
                    int newtop = top + stack.peek();
                    stack.push(top);
                    stack.push(newtop);
                    break;
                }
                case "D":{
                    stack.push(2*stack.peek());
                    break;
                }
                case "C":{
                    stack.pop();
                    break;
                }
                default:{
                    stack.push(Integer.valueOf(s));
                }
            }
        }
        int sum = 0;
        for (int score:stack){
            sum += score;
        }
        return sum;
    }
}
