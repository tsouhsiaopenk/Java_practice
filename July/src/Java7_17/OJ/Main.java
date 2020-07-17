package Java7_17.OJ;

import org.junit.Test;

import java.util.Scanner;

/**
 * 坐标移动：（WADS）
 * A：向左移动
 * S：向下移动
 * W：向上移动
 * D：向右移动
 */
public class Main {
    static int x = 0;
    static int y = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            // 读入数据
            String str = scanner.nextLine().trim();
            // 使用 ; 分割字符串
            String[] operator = str.split(";");
            // 坐标移动操作
            movePoint(operator);
        }
    }

    private static void movePoint(String[] operator) {
        for (String s : operator) {
            // 1.操作合法性校验
            boolean state = isLegal(s);
            if (!state) {
                continue;
            }
            // 2.进行移位操作
            String direct = s.substring(0, 1);
            String step = s.substring(1);
            switch (direct) {
                case "W":
                    y += Integer.parseInt(step);
                    break;
                case "A":
                    x -= Integer.parseInt(step);
                    break;
                case "S":
                    y -= Integer.parseInt(step);
                    break;
                case "D":
                    x += Integer.parseInt(step);
                    break;
            }
        }
        // 3.输出坐标
        System.out.println(x + "," + y);
        x = 0;
        y = 0;
    }

    private static boolean isLegal(String s) {
        if (s.equals("") || s.length() > 3) {
            return false;
        }
        // 判断direct是否为WASD中其中一个
        String direct = s.substring(0, 1);
        // 判断是否为数字
        String step = s.substring(1);
        int flag = 0;
        if (direct.equals("W") ||
                direct.equals("A") ||
                direct.equals("S") ||
                direct.equals("D")) {
            flag++;
        }
        for (int i = 0; i < step.length(); i++) {
            if (!Character.isDigit(step.charAt(i))) {
                return false;
            }
        }
        flag++;
        return flag == 2;
    }

    @Test
    public void test() {
        String s = "abcde";
        String direct = s.substring(0, 1);
        String step = s.substring(1);
        System.out.println(direct);
        System.out.println(step);
    }
}
