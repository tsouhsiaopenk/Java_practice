package Java4_7;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    public int num1;
    public int num2;
    public int sum;

    public Pair(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.sum = num1 + num2;
    }

    @Override
    public int compareTo(Pair o) {
        // 用 sum 的值来衡量 Pair 的大小
        return this.sum - o.sum;
    }
}

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }
        // 当前采取的是前 k 小的元素，就建立一个小堆
        PriorityQueue<Pair> queue = new PriorityQueue<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                queue.offer(new Pair(nums1[i], nums2[j]));
            }
        }
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            Pair cur = queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(cur.num1);
            tmp.add(cur.num2);
            result.add(tmp);
        }
        return result;
    }
}
