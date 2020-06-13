package Java6_13.OJ;

import org.junit.Test;

/**
 * 无缓存交换
 * 带交换元素在第0个和第1个元素
 */
public class Exchange {
    // 此处使用异或运算来完成交换
    public int[] exchangeAB(int[] AB) {
        // write code here
        // 第一次运算得到的是一个辅助的结果
        AB[0] = AB[0] ^ AB[1];
        AB[1] = AB[0] ^ AB[1];
        AB[0] = AB[0] ^ AB[1];
        return AB;
    }

    @Test
    public void test() {
        int[] a = new int[]{3, 5};
        int[] b = exchangeAB(a);
        System.out.println(b[0] + ":" + b[1]);
    }
}
