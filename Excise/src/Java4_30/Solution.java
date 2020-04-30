package Java4_30;

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 暴力求解
//        for (int i = 0; i <matrix.length ; i++) {
//            for (int j = 0; j <matrix[i].length ; j++) {
//                if (target == matrix[i][j]){
//                    return true;
//                }
//            }
//        }
//        return false;
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // 先得到矩阵右上角的行和列
        int m = matrix.length;
        int n = matrix[0].length;
        // 定义两个关于行和列的变量
        int row = 0;
        int col = n - 1;
        // 循环条件只需要满足行列不为非法值即可
        //  0 <= row < m 和 0 <= col < n
        while (row < m && col >= 0) {
            if (matrix[row][col] > target) {
                // 如果目标值小于此处的值，去左边找
                col--;
            } else if (matrix[row][col] < target) {
                // 如果目标值大于此处的值，去下边找
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
