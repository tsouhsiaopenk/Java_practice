package Java5_19;

import java.util.Scanner;
import java.util.Stack;

/**
 * 编译原理实验：预测分析法
 * 文法：
 * G[E]:E->E+T|T，T->T*F|F，F->(E)|i
 * 消除左递归：
 * G'[E]:E->TE'，E'->+TE'|ε，T->FT'，T'->*FT'|ε，F->(E)|i
 */
public class PredictiveAnalysis {
    // 预测分析表
    private String[][] analysisTable = {
            {"TE1", "", "", "TE1", "", ""},
            {"", "+TE1", "", "", "$", "$"},
            {"FT1", "", "", "FT1", "", ""},
            {"", "$", "*FT1", "", "$", "$"},
            {"i", "", "", "(E)", "", ""}
    };

    // 输入要分析的字符串
    private String input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入以#结尾的字符串：");
        String s = scanner.nextLine();
        scanner.close();
        return s;
    }

    /*
        驱动控制程序
        输入：要分析的源程序串（以#结尾）
        输出：分析过程和结果
     */
    private void drive(String token) {
        // 建立分析栈
        Stack<String> anaStack = new Stack<>();
        // 初始化分析栈
        anaStack.push("#");
        anaStack.push("E");
        // 打印操作
        System.out.println("缓冲区" + token + "\t\t\t\t" + "当前栈" + anaStack.toString() + "无产生式");
        // 只要栈不为空,就需要重复下面的操作
        while (!anaStack.isEmpty()) {
            // 将从左向右扫描到的第一的符号记作firstChar
            String firstChar = "" + token.charAt(0);
            // 如果栈顶和扫描到的一致，就出栈,缓冲区向元素指向下一个
            if (anaStack.peek().equals(firstChar)) {
                if (anaStack.peek().equals("#")) {
                    break;
                }
                anaStack.pop();
                token = token.substring(1);
                // 打印操作
                System.out.print("缓冲区" + token + "\t\t\t\t");
                System.out.print("当前栈" + anaStack.toString() + "\t\t\t\t");
                System.out.println("无产生式");// 相等时不用打印产生式（没有）
                continue;
                // 下边if的注释：得到栈顶元素，然后进行栈操作
            } else if (!anaStack.peek().equals(firstChar)) {
                // 得到行列下标
                int row = getRow(anaStack.peek());
                int col = getCol(firstChar);
                // 如果行列下标非法,终止程序
                if (row == -1 || col == -1) {
                    System.out.println("不可接受字符串！");
                    System.exit(0);
                }
                // 依据栈顶元素和扫描到的字符从表中找到value，即下一步需要栈操作的产生式
                String value = analysisTable[row][col];
                // 若栈顶为空，栈顶元素出栈
                if (value.equals("$")) {
                    String v = anaStack.pop();
                    System.out.print("缓冲区" + token + "\t\t\t\t");
                    System.out.print("当前栈" + anaStack.toString() + "\t\t\t\t");
                    System.out.println("产生式" + v + "->$" + "\t\t\t\t");
                    continue;
                }
                // 进行栈操作
                String p = anaStack.pop();
                if (value.equals("TE1")) {
                    anaStack.push("E1");
                    anaStack.push("T");
                } else if (value.equals("FT1")) {
                    anaStack.push("T1");
                    anaStack.push("F");
                } else if (value.equals("i")) {
                    anaStack.push("i");
                } else if (value.equals("(E)")) {
                    anaStack.push(")");
                    anaStack.push("E");
                    anaStack.push("(");
                } else if (value.equals("*FT1")) {
                    anaStack.push("T1");
                    anaStack.push("F");
                    anaStack.push("*");
                } else if (value.equals("+TE1")) {
                    anaStack.push("E1");
                    anaStack.push("T");
                    anaStack.push("+");
                }

                System.out.print("缓冲区" + token + "\t\t\t\t");
                System.out.print("当前栈" + anaStack.toString() + "\t\t\t\t");
                System.out.println("产生式" + p + "->" + value + "\t\t\t\t");
            }
        }
    }

    // 依据预测分析表的列名得到其列下标
    private int getCol(String s) {
        switch (s) {
            case "i":
                return 0;
            case "+":
                return 1;
            case "*":
                return 2;
            case "(":
                return 3;
            case ")":
                return 4;
            case "#":
                return 5;
        }
        return -1;
    }

    // 依据预测分析表的行名得到其行下标
    private int getRow(String ch) {
        switch (ch) {
            case "E":
                return 0;
            case "E1":
                return 1;
            case "T":
                return 2;
            case "T1":
                return 3;
            case "F":
                return 4;
        }
        return -1;
    }


    public static void main(String[] args) {
        PredictiveAnalysis pa = new PredictiveAnalysis();
        // 1.输入要分析的字符串
        String token = pa.input();
        // 2.进行分析
        pa.drive(token);
    }
}
