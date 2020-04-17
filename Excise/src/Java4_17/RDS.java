package Java4_17;

/*
       表达式文法的递归子程序分析
          G'[E]:E → TE'
                E' → +TE' | ε
                T → FT'
                T' → *FT' | ε 
                F → (E) | i
 */
public class RDS {
    // 字符串始终指向的下标
    private char lookHead = 0;
    private String string;

    // 通过构造方法传入一个字符串
    public RDS(String string) {
        this.string = string;
    }

    // 匹配终结符  传入终结符 如果匹配则读下一个
    public void match(char token) {
        // 判断是否匹配
        if (string.charAt(lookHead) == token){
            lookHead++;
        }else{
            // 失败退出
            System.out.println("error!");
            System.exit(0);
        }
    }
    // E ->TE' 以下 ' 全部用 _ 代替
    public void E() {
        T();
        E_();
    }
    // T ->FT'
    private void T() {
        F();
        T_();
    }
    // T' ->*FT' | ε
    private void T_() {
        // 遇到终结符 '*', 调用match()
        if (string.charAt(lookHead) == '*'){
            F();
            T_();
        }
    }
    // F -> (E) | id
    private void F() {
        if (string.charAt(lookHead) == 'i'){
            match('i');
        }else if (string.charAt(lookHead) == '('){
            match('(');
            E();
            if (string.charAt(lookHead) == ')'){
                match(')');
            }else{
                System.out.println("error!");
            }
        }
    }
    // E' → +TE' | ε
    private void E_() {
        // 遇到终结符 '+' ，调用match()
        if (string.charAt(lookHead) == '+'){
            match('+');
            T();
            E_();
        }
        // 候选式是 ε
    }


    public static void main(String[] args) {
        RDS rds = new RDS("i + i * i");
        rds.E();
    }
}
