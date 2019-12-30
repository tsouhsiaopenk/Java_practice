public class countOne {
    // 求一个整数，在内存当中存储时，二进制1的个数
    public static int count(int num){
        int count =0;
        while(true){
            if(num%2==1){
                count++;
            }
            if(num<=1){
                break;
            }
            num/=2;
        }
        return count;
    }
    public static void main(String[] args) {
        for(int i=0;i<20;i++){
            System.out.print(i +" ");
            System.out.print(count(i)+" ");
            System.out.println();
        }

    }
}
