package Java4_26;

public class Solution {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int prev = chars[0];
        for (int i = 1; i < chars.length; i++) {
            int num = getValue(chars[i]);
            if (prev > num) {
                result += num;
            } else {
                result -= num;
            }
            prev = num;
        }
        result += prev;
        return result;
    }

    private int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
