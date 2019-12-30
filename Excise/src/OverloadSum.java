public class OverloadSum {
    // 输入两个整数，返回其中的最大值
    public static int max(int a,int b){
        return a>b?a:b;
    }
    // 输入两个浮点数，返回其中的最大值
    public static double max(double a,double b){
        return a>b?a:b;
    }
    public static void rela(int a,int b,double c){
        if(a>b&&b>c){
            System.out.println("a>b>c");
        }else if(a>c&&c>b){
            System.out.println("a>c>b");
        }else if(b>a&&a>c){
            System.out.println("b>a>c");
        }else if(b>c&&c>a){
            System.out.println("b>c>a");
        }else if(c>a&&a>b){
            System.out.println("c>a>b");
        }else if(c>b&&b>a){
            System.out.println("c>b>a");
        }
    }
    public static void main(String[] args) {
        System.out.println("两个数字： 4 5");
        System.out.println(max(4,5));
        System.out.println("三个数字： 4.5 6.1 7.9");
        System.out.println(max(4.5,6.1));
        System.out.println("三个数字的关系： 2,4,3.5");
        rela(2,4,3.5);
    }
}
