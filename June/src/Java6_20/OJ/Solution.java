package Java6_20.OJ;

public class Solution {
    public static void main(String[] args) {
        // 富翁交出的钱(30天，每天10万)
        System.out.println(30 * 10);
        // 陌生人交出的钱
        double strangerMoney = 0;
        for (int i = 0; i < 30; i++) {
            strangerMoney += Math.pow(2, i);
        }
        System.out.println((int) strangerMoney);
    }
}
