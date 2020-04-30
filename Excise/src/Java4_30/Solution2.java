package Java4_30;

public class Solution2 {
    public String replaceSpace(String s) {
        if (s.length() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }


}
