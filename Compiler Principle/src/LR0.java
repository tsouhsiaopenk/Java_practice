import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LR0分析法
 * 1.S->A
 * 2.A->aA
 * 3.A->b
 */
public class LR0 {
    // action表
    private String[][] action = {
            {"S2", "S3", "-1"},
            {"-1", "-1", "acc"},
            {"S2", "S3", "-1"},
            {"r3", "r3", "r3"},
            {"r2", "r2", "r2"},
    };
    // goto表
    private int[] goTo = {1, -1, 4, -1, -1};
    // 类下标对应的种类
    private Map<Character, Integer> col = new HashMap<Character, Integer>() {{
        put('a', 0);
        put('b', 1);
        put('#', 2);
    }};

    // 在外部传入待识别的字符换
    private String toIdentifyString = null;

    // 构造方法
    public LR0(String toIdentifyString) {
        this.toIdentifyString = toIdentifyString;
    }

    // 输入一个字符串，判断是否满足文法,这里将待识别字符串设置为成员变量
    public boolean isMeetGrammar() {
        // 符号栈
        Stack<Character> symbolStack = new Stack<>();
        // 状态栈
        Stack<Integer> stateStack = new Stack<>();
        // 初始化栈
        symbolStack.push('#');
        stateStack.push(0);

        // 在下边的for循环外部创建创建变量，减少空间开销
        int column = 0;
        int state = 0;
        char c = '0';
        // 遍历字符串
        for (int i = 0; i < this.toIdentifyString.length(); i++) {
            // 得到当前扫描到的字符
            c = this.toIdentifyString.charAt(i);
            // 根据输入字符计算列号
            column = col.get(c);
            // 从状态栈顶拿到当前状态
            state = stateStack.peek();
            // 从 action表 中找到下一步的操作
            String act = action[state][column];
            // 判断是否发生归约
            boolean isReduce = true;
            while (isReduce) {
                // 一般情况下，都是通过action表项中的不同内容执行以下动作
                // (1).可接受状态,即合法字符串
                if (act.equals("acc")) {
                    return true;
                }
                // (2).检测到 -1,非法字符串
                if (act.equals("-1")) {
                    return false;
                }
                // (3).检测到 S 代表移进状态
                if (act.charAt(0) == 'S') {
                    // 当 action[Sm,ai] = S2 时候
                    if (act.charAt(1) == '2') {
                        symbolStack.push(c);
                        stateStack.push(2);
                    } else { // 当 action[Sm,ai] = S3 时候
                        symbolStack.push(c);
                        stateStack.push(3);
                    }
                    // 发生了移进就不会归约
                    isReduce = false;
                }
                // (4).检测到 r 代表归约状态
                if (act.charAt(0) == 'r') {
                    // 当 action[Sm,ai] = r3 时候
                    if (act.charAt(1) == '3') {
                        // 1.符号栈修改:将栈顶的 b 丢掉，放进去一个A
                        symbolStack.pop();
                        symbolStack.push('A');
                        // 2.状态栈状态修改
                        stateStack.pop();
                        stateStack.push(goTo[stateStack.peek()]);

                        state = stateStack.peek();
                        act = action[state][column];
                    } else if (act.charAt(1) == '2') {// 当 action[Sm,ai] = r2 时候
                        // 1.符号栈修改：将栈顶的 A,a都丢掉，放入一个A
                        symbolStack.pop();
                        symbolStack.pop();
                        symbolStack.push('A');
                        // 2.状态栈状态修改
                        stateStack.pop();
                        stateStack.pop();
                        stateStack.push(goTo[stateStack.peek()]);

                        state = stateStack.peek();
                        act = action[state][column];
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] tests = {
                "a#", "b#", "ab#", "ba#", "aa#", "bb#", "aab#", "aba#"
        };
        for (int i = 0; i < tests.length; i++) {
            LR0 lr0 = new LR0(tests[i]);
            System.out.print(lr0.isMeetGrammar() + " ");
        }
    }
}



