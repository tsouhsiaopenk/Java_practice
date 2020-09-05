package Java.Test;

import org.junit.Test;

import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        // Arrays.sort(input);
        // 默认为升序
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = 0; i < input.length;i++){
            queue.offer(input[i]);
        }
        for(int i = 0;i < k;i++){
            res.add(queue.poll());
        }
        return res;
    }

    @Test
    public void test(){
        int[] input = {4,5,6,2,7,3,8,46,2,3};
        Solution solution = new Solution();
        ArrayList<Integer> res = solution.GetLeastNumbers_Solution(input,4);
        System.out.println(res.toString());
    }
}
