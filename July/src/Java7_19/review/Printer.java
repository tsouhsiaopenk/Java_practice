package Java7_19.review;

// 二维数组的打印
public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        int[] res = new int[n*n];
        int index = 0;
        // 开始时的坐标
        int startX = 0;
        int startY = n - 1;
        while (startX < n) {
            int x = startX;
            int y = startY;
            while (x < n && y < n) {
                res[index++] = arr[x++][y++];
            }
            if (startY > 0) {
                startY--;
            } else {
                startX++;
            }
        }
        return res;
    }
}
