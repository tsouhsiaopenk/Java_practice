package Java5_4;

public class Solution2 {
    public static int numWays(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return numWays(n - 1) + numWays(n - 2);
    }

    public static int numWays1(int n) {
        if (n == 0) {
            return 0;
        }
        int tmp1 = 1;
        int tmp2 = 1;
        if (n == 1) {
            return tmp1;
        }
        if (n == 2) {
            return tmp2;
        }
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = (tmp1 + tmp2) % 1000000007;
            tmp1 = tmp2;
            tmp2 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numWays(2));
        System.out.println(numWays(3));
        System.out.println(numWays(5));
        System.out.println(numWays(7));
    }
}
