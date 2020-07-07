package Java7_7.OJ;

import org.junit.Test;

public class Count2 {
    public static int countNumberOf2s(int n) {
        // write code here
        int count = 0;;
        for(int i = 2;i<=n;i++) {

        }
        return count;
    }
    // 方法二：时间复杂度高
    public static int countNumberOf2s_2(int n) {
        // write code here
        int count = 0;;
        for(int i = 2;i<=n;i++) {
            int cur = i;
            while (cur != 0) {
                int tmp = cur % 10;
                if (tmp == 2) {
                    count++;
                }
                cur = cur / 10;
            }
        }
        return count;
    }
    // 方法一：时间复杂度高
    public static int countNumberOf2s_1(int n) {
        // write code here
        int count = 0;;
        for(int i = 2;i<=n;i++){
            String s = String.valueOf(i);
            for(int j=0;j<s.length();j++){
                if(s.charAt(j) == '2'){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Count2.countNumberOf2s(999999999));
    }

    @Test
    public void test(){
        System.out.println(2/10);
    }
}
