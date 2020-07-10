package Java7_10.OJ;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    /**
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public int calculateMax(int[] prices) {
        // 1.计算买一次,在整个数组中找左边小于右边值得最优解，即跨度最大
        int first = getMax(prices);
        // 2.计算买两次:将数据分成两部分计算 left [0,bound) [bound,prices.length]
        int second = 0;
        for (int bound = 2; bound < prices.length; bound++) {
            // Arrays.copyOfRange() 是闭区间
            int[] left = Arrays.copyOfRange(prices, 0, bound);
            int[] right = Arrays.copyOfRange(prices, bound, prices.length);

            int l = getMax(left);
            int r = getMax(right);
            int diff = l + r;
            second = Math.max(diff, second);
        }
        return Math.max(first, second);
    }

    private int getMax(int[] prices) {
//        if (prices.length == 1) {
//            return prices[0];
//        }
        int different = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int tmp = prices[j] - prices[i];
                    different = Math.max(different, tmp);
                }
            }
        }
        return different;
    }

    @Test
    public void test() {
        int[] prices = {3, 8, 5, 1, 7, 8};
        System.out.println(calculateMax(prices));
    }

    @Test
    public void t1() {
        int[] prices = {3, 8, 5, 1, 7, 8};
        for (int bound = 1; bound <= prices.length; bound++) {
            // Arrays.copyOfRange() 左闭右开
            int[] left = Arrays.copyOfRange(prices, 0, bound);
            System.out.println(Arrays.toString(left));
            int[] right = Arrays.copyOfRange(prices, bound, prices.length);
            System.out.println(Arrays.toString(right));
            System.out.println();
        }
//        int[] left = Arrays.copyOfRange(prices,0,1);
//        System.out.println(Arrays.toString(left));
    }
}
