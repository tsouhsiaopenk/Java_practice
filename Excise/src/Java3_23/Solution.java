package Java3_23;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
        位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
        位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
        位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        // 重复k次
        for (; k > 0; k--) {
            int[][] newGrid = new int[grid.length][grid[0].length];
            // 第一种情况
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length - 1; col++) {
                    newGrid[row][col + 1] = grid[row][col];
                }
            }
            // 第二种情况
            for (int row = 0; row < grid.length - 1; row++) {
                newGrid[row+1][0] = grid[row][grid[0].length-1];
            }
            // 第三种情况
            newGrid[0][0] = grid[grid.length-1][grid[0].length-1];
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid){
            List<Integer> listRow = new ArrayList<>();
            result.add(listRow);
            for (int v : row){
                listRow.add(v);
            }
        }
        return result;
    }
}
