package Java5_4;

public class Test {
    public int fib(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        return fib(n - 1) + fib(n - 2);
        int tmp1 = 0;
        int tmp2 = 1;
        int result = 0;
        if (n == 0){
            return tmp1;
        }
        if (n == 1){
            return tmp2;
        }
        for (int i = 2; i <= n ; i++) {
            result = (tmp1 + tmp2)% 1000000007;
            tmp1 = tmp2;
            tmp2 = result;
        }
        return result;
    }
}
