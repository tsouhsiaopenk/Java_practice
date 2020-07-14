package Java7_14.OJ;

import org.junit.Test;

/**
 * 空格替换：
 * 直接使用replace方法
 */
public class Replacement {
    public String replaceSpace(String iniString, int length) {
        // write code here
        return  iniString.replace(" ","%20");
    }


    @Test
    public void t(){
        System.out.println(replaceSpace("Mr John Smith",13));
    }
}
