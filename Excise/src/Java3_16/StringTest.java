package Java3_16;

public class StringTest {
    // index的实现
    public static int indexof(String text, String pattren) {
        // 父串每次后移一位
        for (int i = 0; i < text.length(); i++) {
            int cur = i;
            // 子串从当前父串的位置开始进行匹配
            for (int j = 0; j < pattren.length(); j++) {
                // 两个字符比较
                if (pattren.charAt(j) == text.charAt(cur)) {
                    if (j == (pattren.length() - 1) && text.charAt(cur) == pattren.charAt(j)) {
                        return i;
                    }
                    cur++;
                    continue;
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "西安科技大学计算机学院软件工程";
        String pattern = "zhouxiao";
        int result = indexof(text, pattern);
        //System.out.println(text.charAt(2));
        System.out.println(result);
    }
}
