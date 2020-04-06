package Java4_6;

import java.util.Scanner;

public class Main {

    final static int DIGIT = 1;
    final static int POINT = 2;
    final static int OTHER = 3;
    final static int POWER = 4;
    final static int PLUS = 5;
    final static int MINUS = 6;
    final static int EndState = -1;
    static Scanner sc = new Scanner(System.in);

    static String str;
    static int w = 0;    //整数部分
    static int p = 0;    //小数部分
    static int e = 1;    //幂次是+ 还是 -
    static int d = 0;    //暂存数据
    static int n = 0;    //表示小数点后边有几个位
    static int currentState = 0;    //当前状态，默认是0，后面执行的时候还要初始化
    static double result = 0.0;        //result用来存最后结果

    public static void main(String[] args) {
        //测试数据
        String[] strs = {
                "12", "34.567", "89.", ".345", ".", "12E34", "12e34", "12E+34",
                "12e+34", "12e-34", "12.3E4", "12.3e4", "12.3E+4", "12.3e+4",
                "12.3E-4", "12.3e-4", ".38E4", ".3e45", ".38E+4", ".3e+45",
                ".38E-4", ".3e-45", "3.E45", "38.e4", "3.E+45", "38.e+4",
                "3.E-45", "38.e-4"
        };
        for (String str : strs) {
            if (isUnsignedNumber(str) == true) {
                System.out.println(str + " Yes" + " " + result);
            } else {
                System.out.println(str + " No");
            }
        }
    }

    //解析字符，返回相应的状态，前面静态变量定义好了
    public static int analysisCharacter(char c) {
        switch (c) {
            case '.':
                return POINT;
            case 'E':
            case 'e':
                return POWER;
            case '+':
                return PLUS;
            case '-':
                return MINUS;
            default:
                if (Character.isDigit(c)) {
                    d = c - '0';
                    return DIGIT;
                }
                break;
        }
        return OTHER;
    }

    //判断是不是无符号证书，返回相应的状态
    public static boolean isUnsignedNumber(String s) {
        //在这里全部都要重新初始化
        currentState = 0;    //当前状态初始化0
        n = 0;            //小数点后位数初始化0
        w = 0;            //整数部分初始化0
        p = 0;            //小数部分初始化0
        e = 1;            //默认是＋
        for (int i = 0; i < s.length(); i++) {
            int ch = analysisCharacter(s.charAt(i));
            currentToNext(ch);
            if (currentState == EndState) {
                return false;
            }
        }
        switch (currentState) {
            case 1:
            case 2:
            case 6:
                result = w * Math.pow(10, e * p - n);
                return true;
        }
        return false;
    }

    //从当前状态到下一个状态的执行，参数是一个字符串，currentState是静态成员变量不需要传参
    public static void currentToNext(int ch) {
        switch (currentState) {
            case 0:
                switch (ch) {
                    case DIGIT:
                        w = w * 10 + d;
                        currentState = 1;
                        break;
                    case POINT:
                        currentState = 3;
                        break;
                    default:
                        currentState = EndState;
                        break;
                }
                ;
                break;
            case 1:
                switch (ch) {
                    case DIGIT:
                        w = w * 10 + d;
                        currentState = 1;
                        break;
                    case POINT:
                        currentState = 2;
                        break;
                    case POWER:
                        currentState = 4;
                        break;
                    default:
                        currentState = EndState;
                        break;
                }
                ;
                break;
            case 2:
                switch (ch) {
                    case DIGIT:
                        w = w * 10 + d;
                        ++n;
                        currentState = 2;
                        break;
                    case POWER:
                        currentState = 4;
                        break;
                    default:
                        currentState = EndState;
                        break;
                }
                ;
                break;
            case 3:
                switch (ch) {
                    case DIGIT:
                        w = w * 10 + d;
                        ++n;
                        currentState = 2;
                        break;
                    default:
                        currentState = EndState;
                        break;
                }
                ;
                break;
            case 4:
                switch (ch) {
                    case DIGIT:
                        p = p * 10 + d;
                        currentState = 6;
                        break;
                    case PLUS:
                        currentState = 5;
                        break;
                    case MINUS:
                        e = -1;
                        currentState = 5;
                        break;
                    default:
                        currentState = EndState;
                        break;
                }
                ;
                break;
            case 5:
                switch (ch) {
                    case DIGIT:
                        p = p * 10 + d;
                        currentState = 6;
                        break;
                    default:
                        currentState = EndState;
                        break;
                }
                ;
                break;
            case 6:
                switch (ch) {
                    case DIGIT:
                        p = p * 10 + d;
                        currentState = 6;
                        break;
                    default:
                        currentState = EndState;
                        break;
                }
                break;
        }
    }
}
