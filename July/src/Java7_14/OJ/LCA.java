package Java7_14.OJ;

import org.junit.Test;

/**
 * 最近公共祖先：
 * 又臭又长的代码
 */
public class LCA {

    @Test
    public void t() {
        System.out.println(getLCA(8, 10));
    }

    public int getLCA(int a, int b) {
        // 如果其中有一个是根节点，直接返回1，就没有计算的必要了
        if (a == 1 || b == 1) {
            return 1;
        }
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        // 使得max的值小于等于min
        while (max > min) {
            max /= 2;
        }
        // 如果max == min，就说明找到了公共祖先结点，即min是祖先结点
        if (min == max) {
            return min;
        }
        // 如果上面的不成立，max 的值小于 min 且min不是祖先结点，此时有两种情况
        // 1.此时两个结点在同一层（且在同一子树下）
        if (max == min / 2) {
            return max;
        }
        // 2.此时两个结点不在同一层（且不在同一子树下）
        if (max / 2 == min / 2) {
            return min / 2;
        }
        return getLCA(max / 2, min / 2);
    }
}
