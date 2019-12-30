public class Numerations {
    //水仙花数字
    public static boolean daffodils(int num){
        int hundred = num/100;
        int ten = num/10%10;
        int digit = num%10;
        if(hundred*hundred*hundred+ten*ten*ten+digit*digit*digit==num){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        for(int i=0;i<=999;i++){
            if(daffodils(i)){
                System.out.println(i);
            }
        }
    }
}
