public class Hannio {
    public static void move(char a,char b){
        System.out.println("将盘子从"+a+"移动到"+b);
    }
    // 将 a 上的 n个圆盘借助b，移动到c
    public static void hannioTower(int n,char a,char b,char c){
        if(n == 1){
            move(a,c);
        }
        else{
            // 借助c,将n-1个圆盘由a移动到b
            hannioTower(n-1,a,c,b);
            // 将剩余的一个圆盘，由a移动到c
            move(a,c);
            // 将剩下的盘子，借助a,把b柱上的n-1个盘子移动到c
            hannioTower(n-1,b,a,c);
        }
    }
    public static void main(String[] args) {
        char a = 'a';
        char b = 'b';
        char c = 'c';
        hannioTower(3,a,b,c);
    }
}
