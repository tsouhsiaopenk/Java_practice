package Java6_5.CorrectMistakes;

import org.junit.Assert;
import org.junit.Test;

public class SystemUtil {
    public static void main(String[] args) {
        System.out.println(isAdmin("Admin"));
    }

    private static boolean isAdmin(String userId) {
        return userId.toLowerCase() == "admin";
    }
    /*
        这个题的答案时false

     */
    @Test
    public void t(){
        String s1 = "hello ";
        String s2 = "world";
        String s3 = s1 + s2;
        String s = "hello world";
        Assert.assertTrue(s == s3);
    }

    @Test
    public void test2(){// 测试通过
        String s1 = "hello";
        String s2 = "hel" + "lo";
        Assert.assertTrue(s1 == s2);
    }
}
