package Java6_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(count(arr, 8));
    }

    public static class Combination {
        Integer first;
        Integer second;

        public Combination(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

    }

    public int count(int[] A, int n) {
        // 合法性校验
        if (A.length != n) {
            return -1;
        }
        List<Combination> list = combine(A);
        int result = 0;
        for (Combination c : list) {
            // 题目要求前一个大于后一个，相对于他们在数组中的位置
            if (c.first > c.second) {
                result++;
            }
        }
        return result;
    }

    private List<Combination> combine(int[] a) {
        List<Combination> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                result.add(new Combination(a[i], a[j]));
            }
        }
        return result;
    }

    @Test
    public void testCombine() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0};
        List<Combination> result = combine(arr);
        int count = 0;
        for (Combination c : result) {
            System.out.println(c.first + " :" + c.second);
            count++;
        }
        System.out.println("count :" + count);
    }
}
