package Java1_23;

public class test {
    public void mystery(int x) {
        System.out.println(x % 10);
        if ((x / 10) != 0) {
            mystery(x / 10);
        }
        System.out.println(x % 10);
    }

    public String toLowerCase(String str) {
        // 字符串为空时
        if (str == null) {
            return null;
        }
        // 创建一个字符数组，保存转换之后的结果
        char[] array = new char[str.length()];
        // 当字符串不为空时，遍历字符串的每一个字符，进行转换
        for (int i = 0; i < str.length(); i++) {
            // 使用Integer.valueof()方法可以直接获取一个字符的ascall码
            if (str.charAt(i) >= Integer.valueOf('A')
                    && str.charAt(i) <= Integer.valueOf('Z')) {
                char newChar = (char) (str.charAt(i) + 32);
                array[i] = newChar;
            }else {
                array[i] = (char)str.charAt(i);
            }
        }
        return String.copyValueOf(array);
    }

    public static void main(String[] args) {
        test test1 = new test();
        String str = "Hello";
        System.out.println(test1.toLowerCase(str));
    }

}
