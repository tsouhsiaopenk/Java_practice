public class Sum {
    public static int sum(int a,int b){
        return a+b;
    }
    public static double sum(double a,double b,double c){
        return a+b+c;
    }
    public static void main(String[] args) {
        System.out.println(sum(2,3));
        System.out.println(sum(2.5,3.5,2.01));
    }
}
