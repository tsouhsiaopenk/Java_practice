package Java7_3.review;

import java.util.Scanner;

// 人民币转换
public class Main {
    // 阿拉伯数字对应的中文
    public static String[] map = {"壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String number = scanner.next();
            resolve(number);
        }
        scanner.close();
    }

    private static void resolve(String str) {
        // ·是特殊字符，需要转义
        String[] strArr = str.split("\\.");

        int number = Integer.parseInt(strArr[0]);

        StringBuilder res = new StringBuilder("人民币");
        int yi = (int) (number) / 100_000_000;
        if (yi != 0) {
            res.append(resolveQian(yi)).append("亿");
            number = number - yi * 100_000_000;
        }

        int wan = (int) (number / 10_000);
        if (wan != 0) {
            res.append(resolveQian(wan)).append("万");
            number = number - wan * 10_000;
        }

        // 处理千百十个
        String beforePointString = resolveQian(number);
        if (beforePointString.length() > 1) {
            res.append(beforePointString).append("元");
        }
        // 小数点处理
        if (strArr.length > 1) {
            String afterPointStr = strArr[1];
            res.append(handleNumberAfterPoint(afterPointStr));
        }
        // 在最高位置不能有0
        String resString = res.toString();

        if (resString.length() > 4 && resString.charAt(3) == '零' && resString.charAt(4) != '元') {
            // 最高位的零去掉
            resString = res.substring(0, 3) + resString.substring(4);
        }
        System.out.println(resString);
    }

    private static String handleNumberAfterPoint(String str) {
        String res = "";
        if (str.equals("00") || str.equals("0")) {
            res = "整";
        } else {
            if (str.charAt(0) != '0') {
                res += map[Integer.parseInt(str.charAt(0) + "") - 1] + "角";
            }
            if (str.length() > 1 && str.charAt(1) != '0') {
                res += map[Integer.parseInt(str.charAt(1) + "") - 1] + "分";
            }
        }
        return res;
    }

    // 处理4位数，千百十个位
    private static String resolveQian(double temp) {
        StringBuilder res = new StringBuilder();

        // 千位
        int qian = (int) (temp / 1000);
        if (qian != 0) {
            res.append(map[qian - 1]).append("仟");
            temp = temp - qian * 1000;
        }
        // 百位
        int bai = (int) (temp / 100);
        if (bai != 0) {
            res.append(map[bai - 1]).append("佰");
            temp = temp - bai * 100;
        }
        // 零只会添加在百位和十位
        if (qian != 0 && bai == 0) {
            res.append("零");
        }
        int shi = (int) (temp / 10);
        if (shi != 0) {
            if (shi != 1) {
                res.append(map[shi - 1]);
            }
            res.append("拾");
            temp = temp - shi * 10;
        }
        // 注意 ： 0
        if (bai != 0 && shi == 0) {
            res.append("零");
        }
        // 个位
        int ge = (int) (temp % 10);

        if (ge != 0) {
            // 5,0001这种情况，千百十位均为0
            if (qian == 0 && bai == 0 && shi == 0) {
                res.append("零");
            }
            res.append(map[ge - 1]);
        }
        return res.toString();
    }
}
