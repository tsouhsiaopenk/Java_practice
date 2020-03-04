package Java3_4;


public class Solution {
    /*
        给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
        假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
        请根据这个假设，如果反转后整数溢出那么就返回 0。
        −2^31 = -2,147,483,648
        2^31 − 1 = 2,147,483,647
     */
    public int reverse(int x) {
        int ans = 0;
        while(x != 0){
            // 得到每次 当前数字的最后一位（可能是正，可能是负数）
            int pop = x % 10;
            // 当ans> Integer.MAX_VALUE / 10 且pop还需要添加时，一定溢出
            // 当ans == Integer.MAX_VALUE / 10 && pop > 7时
            // 则一定溢出， 7 是 2^32 - 1的个位数
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            // 当ans < Integer.MIN_VALUE / 10 且还有pop还需要添加时候，则一定溢出
            // 当ans == Integer.MIN_VALUE / 10 && pop < -8时
            // 则一定溢出, -8是-2^32的个位数
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)){
                return 0;
            }
            ans = ans*10 +pop;
            x = x / 10;
            }
        return ans;
        }
}
