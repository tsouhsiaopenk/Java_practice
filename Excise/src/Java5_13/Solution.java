package Java5_13;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // 状态转换表
    int[][] stateTable = {
            {-1, 1, 3, -1, -1, 0},
            {-1, 1, 2, 4, -1, 7},
            {-1, 2, -1, 4, -1, 7},
            {-1, 2, -1, -1, -1, -1},
            {5, 6, -1, -1, -1, -1},
            {-1, 6, -1, -1, -1, -1},
            {-1, 6, -1, -1, -1, 7},
            {-1, -1, -1, -1, -1, 7},
    };
    // 类下标对应的种类
    Map<String, Integer> col = new HashMap<String, Integer>() {{
        put("sign", 0);
        put("number", 1);
        put(".", 2);
        put("exp", 3);
        put("other", 4);
        put("blank", 5);
    }};
    // 合法的结束数组
    Integer[] end = {1, 2, 6, 7};
    List<Integer> legalState = Arrays.asList(end);

    // 确定性有限自动机的开始状态
    int state = 0;

    public boolean isUnsignedNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            state = stateTable[state][col.get(getCol(s.charAt(i)))];
            // 非法状态直接结束
            if (state == -1) {
                return false;
            }
        }
        if (legalState.contains(state)) {
            return true;
        }
        return false;
    }

    private String getCol(char c) {
        if (c == '+' || c == '-') {
            return "sign";
        }
        if ('0' <= c && c <= '9') {
            return "number";
        }
        if (c == '.') {
            return ".";
        }
        if (c == 'e' || c == 'E') {
            return "exp";
        }
        if (c == ' ') {
            return "blank";
        }
        return "other";
    }


    public static void main(String[] args) {
        String[] strings = {
                "12","34.567","89.",".345",".","12E34","12e34","12E+34",
                "12e+34","12e-34","12.3E4","12.3e4","12.3E+4","12.3e+4",
                "12.3E-4","12.3e-4",".38E4",".3e45",".38E+4",".3e+45",
                ".38E-4",".3e-45","3.E45","38.e4","3.E+45","38.e+4",
                "3.E-45","38.e-4"
        };

        for (String str : strings) {
                Solution solution = new Solution();
            if (solution.isUnsignedNumber(str) == true) {
                System.out.println(str + " Yes");
            } else {
                System.out.println(str + " No");
            }
        }
    }
}
