package Java9_3;

public class Solution {
    public boolean Find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int i = 0;
        int j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            if (target < array[i][j]) {
                // 排除当前列
                j--;
            } else if (target > array[i][j]) {
                // 排除当前行
                i++;
            } else {
                return true;
            }
        }
        // 排除掉了所有的，就说没有找到
        return false;
    }
}

