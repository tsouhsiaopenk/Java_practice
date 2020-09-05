package Java7_15.OJ;

public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        int arrLen = arr.length;
        // write code here
        int[] res = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            res[i] = arr[arrLen - 1][arrLen - 1];
        }
        return null;
    }
}
