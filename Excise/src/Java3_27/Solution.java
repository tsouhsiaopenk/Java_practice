package Java3_27;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        // 输入小于等于0的情况下
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        // 若只有一行，1个确定元素1
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if (numRows == 1) {
            return result;
        }
        // 确定第二行，插入两个确定的元素1
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if (numRows == 2) {
            return result;
        }
        // 处理多行（i）
        /*
            第i行有i列元素
            且（i，j） = (i-1,j-1) + (i-1,j)
            第一个元素和最后一个元素都固定是1
         */
        // 从第3行开始
        for (int row = 3; row <= numRows; row++) {
            // 要知道 第 row行，就得知道 row-1行的情况
            List<Integer> prevLine = result.get((row - 1) - 1);
            List<Integer> curLine = new ArrayList<>();
            // 行首固定元素1
            curLine.add(1);
            /*
                循环多少次？（每一行的 i-2个元素都需要计算出来）
                    每一行有row个元素，首尾固定为1，需要计算row-2个元素
                    所以列数总是从2开始，循环row-2次
             */
            for (int col = 2; col < row; col++) {
                int curNum = prevLine.get(col-1-1) + prevLine.get(col-1);
                curLine.add(curNum);
            }
            // 将最后的1添加进去
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
}
