package Java6_4.OJ;


import java.util.*;

public class Solution {
    public static class sixEightNum {
        int sixNum = 0;
        int eightNum = 0;

        public int getSixNum() {
            return sixNum;
        }

        public int getEightNum() {
            return eightNum;
        }

        public void setSixNum(int sixNum) {
            this.sixNum = sixNum;
        }

        public void setEightNum(int eightNum) {
            this.eightNum = eightNum;
        }

        public int sum() {
            return this.eightNum * 8 + this.sixNum * 6;
        }

        public int count() {
            return this.eightNum + this.sixNum;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            // 输入想要购买的数量
            int wantBuy = scanner.nextInt();
            // 返回结果
            int result = leastBag(wantBuy);
            // 输出结果
            System.out.println(result);
        }
    }

    private static int leastBag(int wantBuy) {

        // 先讨论 wantBuy 合法的情况
        sixEightNum num = new sixEightNum();
        int eightNum = wantBuy / 8;
        num.setEightNum(eightNum + 1 );
        while (num.count() != wantBuy) {
            num.setEightNum(num.getEightNum() - 1);
            num.setSixNum(num.getSixNum() + 1);
        }
        return num.count();
    }

}
