package Java3_28;

public class Solution3 {
    public boolean canThreePartsEqualSum(int[] A) {
        // 数组的和
        int sum = 0;
        // 先计算数组的和值
        for(int num:A){
            sum += num;
        }
        // 若总和不是 3 的倍数，直接返回false
        if (sum % 3 != 0){
            return false;
        }
        int oneThird = sum / 3;
        // 计数器
        int count = 0;
        // 进行值累加的一个变量
        int curSum = 0;
        for (int i = 0; i < A.length; i++) {
            curSum += A[i];
            if (curSum == oneThird){
                count++;
                curSum = 0;
            }
        }
        if (count >= 3){
            return true;
        }
        return false;
    }
}
