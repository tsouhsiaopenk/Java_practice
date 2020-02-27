package Java1_31;

public class Soultion2 {
    // 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    public boolean isPalindrome(int x) {
        // 将整数转化为字符串
        String string = String.valueOf(x);
        // 判断第一位和最后一位是否一致，然后时第二位和倒数第二位
        int left = 0;
        int right = string.length() - 1;
        while (string.charAt(left) == string.charAt(right) && left < right) {
            left++;
            right--;
        }
        if (left >= right) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome1(int x) {
        // 特殊情况：
        // 1,当 x < 0 时，x 不是回文数。
        // 2,如果数字的最后一位是 0，为了使该数字为回文，
        //    则其第一位数字也应该是 0,只有 0 满足这一属性
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber/10;
    }

    public boolean isPalindrome2(int x){
        String s = Integer.toString(x);
        char[] strings1 = s.toCharArray();
        char[] strings2 = new char[strings1.length];
        for (int i = strings1.length-1; i >= 0;) {
            for(int j=0 ;j<strings1.length;j++){
                strings2[j]=strings1[i];
                i--;
            }
        }
        if (strings1==strings2) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Soultion2 solution = new Soultion2();
        int x = 1234321;
        boolean palindrome = solution.isPalindrome(x);
        System.out.println(palindrome);
    }
}
