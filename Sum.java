public class Sum {
    //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值 。
    public static void main(String[] args) {
        double sum =0;
        for(int i=1;i<=100;i++){
            if(i%2!=0){//奇数
                sum+=1/(double)i;
            }
            if(i%2==0){//偶数
                sum-=1/(double)i;
            }
        }
        System.out.println(sum);
    }
}
