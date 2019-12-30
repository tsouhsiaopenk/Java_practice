public class Greatestcommondivisor {
    public static int divisor(int a,int b){
        int temp;//自定义整性变量
        if(a<b){
            temp = a;
            a = b;
            b = a;
        }
        while(b != 0){
            temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println(divisor(42,87));
    }
}
