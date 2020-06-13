package Java6_13.OJ;

import org.junit.Test;

/**
 * 生成格雷码
 */
public class GrayCode {
    // 如果要产生n位元的格雷码，那么格雷码的个数为2^n.
    // 利用递归，在每一层前面加上0或者1，然后就可以列出所有的格雷码。
    public String[] getGray(int n) {
        // 保存 n 位格雷码
        String[] grayCode = new String[(int) Math.pow(2, n)];
        if (n == 1) {
            grayCode[0] = "0";
            grayCode[1] = "1";
            return grayCode;
        }
        // 生成 n-1 位格雷码
        String[] pre = getGray(n - 1);
        // n 元格雷码是基于 n - 1 元格雷码来实现的，所以要先求n-1元格雷码
        for (int i = 0; i < pre.length; i++) {
            grayCode[i]  = "0" + pre[i];
            grayCode[grayCode.length - 1 - i] = "1 " + pre[i];
        }
        return grayCode;
    }

    @Test
    public void test(){
        int n  = 1;
        String[] s = getGray(n);
        for (String string:s){
            System.out.print(string + " ");
        }
    }
}
