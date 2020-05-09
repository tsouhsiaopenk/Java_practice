package Java5_8;

public class Solution {
    public int[] printNumbers(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append("9");
        }
        int len = Integer.parseInt(new String(stringBuilder));
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = i+1;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
