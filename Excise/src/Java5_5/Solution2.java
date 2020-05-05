package Java5_5;

public class Solution2 {
    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            N = -N;
            x = 1 / x;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        // 任何数的 0 次方都是 1
        if (n == 0) {
            return 1;
        }
        double res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }
}
