package Java6_17.OJ;

/**
 * 另类加法
 * 二进制加法特点:
 * 位的异或运算跟求‘和’的结果一致：
 * 异或 1^1 = 0   1^0 = 1 0^0 = 0
 * 求和 1+1 = 0   1+0 = 1 0+0 = 0
 * 位的与运算跟求‘进位’的结果一致:
 * 位 与 1&1 = 1 1&0 = 0 0&0 = 0
 * 进位  1+1 = 1 1+0 = 1 0+0 = 0
 */
public class UnusualAdd {
    public int addAB(int A, int B) {
        // 进位标记
        int carry = 0;
        // 和
        int sum = 0;
        // 每次异或都会把一位计算出来
        while (B != 0) {
            sum = A ^ B;
            carry = (A & B) << 1; // 左移
            A = sum;
            B = carry;
        }
        return A;
    }
}
