package Java5_12;

import java.util.*;

public class Solution {
    // 状态转换表
    int[][] stateTable = {
            {1, 2, 7, -1, -1, 0},
            {-1, 2, 7, -1, -1, -1},
            {-1, 2, 3, 4, -1, 9},
            {-1, 3, -1, 4, -1, 9},
            {6, 5, -1, -1, -1, -1},
            {-1, 5, -1, -1, -1, 9},
            {-1, 5, -1, -1, -1, -1},
            {-1, 8, -1, -1, -1, -1},
            {-1, 8, -1, 4, -1, 9},
            {-1, -1, -1, -1, -1, 9}
    };
    // 列下标对应的字符种类（或者说字符种类对应的列下标）
    Map<String, Integer> col = new HashMap<String, Integer>() {
        {
            put("sign", 0);      // +/-
            put("number", 1);    // 数字
            put(".", 2);         // 小数点
            put("exp", 3);       // e/E
            put("other", 4);     // 其他
            put("blank", 5);     // 空格
        }
    };
    // 确定性有限自动机的开始状态
    int state = 0;
    // 合法的结束状态
    Integer[] legalEnd = {2, 3, 5, 8, 9};
    // 合法的结束状态（通过上边的数组构造）
    List<Integer> legalState = Arrays.asList(legalEnd);

    public boolean isNumber(String s) {
        // 1.遍历字符串，进行状态转换
        for (int i = 0; i < s.length(); i++) {
            // 状态转换
            state = stateTable[state][col.get(getCol(s.charAt(i)))];
            // 如果经过转换后到达非法状态，就结束状态转换
            if (state == -1) {
                return false;
            }
        }
        // 2.如果当前状态是合法的结束状态，就说明该字符串是表示数值的字符串
        if (legalState.contains(state)) {
            return true;
        }
        return false;
    }

    private String getCol(char c) {
        if (c == '+' || c == '-') {
            return "sign";
        }
        if (c >= '0' && c <= '9') {
            return "number";
        }
        if (c == '.') {
            return ".";
        }
        if (c == 'E' || c == 'e') {
            return "exp";
        }
        if (c == ' ') {
            return "blank";
        }
        return "other";
    }
}
