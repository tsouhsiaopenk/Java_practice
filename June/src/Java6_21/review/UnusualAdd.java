package Java6_21.review;


import org.junit.Test;

/*
    另类加法
 */
public class UnusualAdd {
    public int addAB(int A, int B) {
        // B为0，即是下边的进位为0，直接返回A（上一次计算得到的sum）作为结果
        if (B == 0) {
            return A;
        }
        // 本位结果
        int sum = A ^ B;
        // 进位结果
        int carry = (A & B) << 1;
        return addAB(sum, carry);
    }


    @Test
    public void test() {
        System.out.println(2 ^ 3);
        System.out.println(2 & 3 << 1);
    }
}
