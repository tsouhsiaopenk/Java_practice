public class FrogJumPingOnStairs {
    /*
        一只青蛙一次可以跳上 1 级台阶，也可以跳上2级。
        求该青蛙跳上一个n级的台阶总共有多少种跳法
     */
    public static int  jumpStairs(int n){
        // 若只有一阶的时候 f(1) = 1 即跳一次
        if(n==1){
            return 1;
        }
        // 若只有两阶的时候 f(2) = 2 即跳两次和跳一次
        if(n==2){
            return 2;
        }
        return jumpStairs(n-1)+jumpStairs(n-2);
    }
    public static void main(String[] args) {
        System.out.println("跳四级台阶有"+jumpStairs(4)+"种方法");
    }
}
