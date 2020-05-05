package Java5_5;

public class Solution {
    public int hammingWeight(int n) {
        int bit = 1;
        String N = Integer.toBinaryString(n);
        int sum = 0;
        for (int i = 0; i < N.length(); i++) {
            if ((N.charAt(i) & bit) == 1){
                sum++;
            }
        }
        return sum;
    }

}
