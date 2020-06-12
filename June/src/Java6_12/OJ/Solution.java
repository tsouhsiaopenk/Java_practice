package Java6_12.OJ;

/**
 * 构建乘积数组
 */
public class Solution {

    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = product(A,i);
        }
        return B;
    }

    private int product(int[] a,int exclude) {
        int pro = 1;
        for (int i = 0; i < a.length; i++) {
            if (i == exclude){
                continue;
            }
            pro *= a[i];
        }
        return pro;
    }
}
