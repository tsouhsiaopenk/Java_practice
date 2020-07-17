package Java7_17.Review;

public class ReplaceSpace {
    // 方法一：
    public String replaceSpace(String iniString,int length){
        char[] ch = iniString.toCharArray();
        if (iniString == null || iniString.length() <= 0){
            return null;
        }

        int mLen = 0; // 计算字符个数
        int numBlank = 0; //计算空格的数组
        int i = 0; // 从0号下标开始遍历

        while (i < ch.length){
            ++mLen;
            if (ch[i] == ' '){
                ++numBlank;
            }
            ++i;
        }
        // 替换后的新数组的长度(空格处改为两个字符)
        int newLen = mLen + numBlank * 2;
        // 新的数组
        char[] ch2 = new char[newLen];
        // 先把ch里边的内容全部拷贝到ch2里边
        System.arraycopy(ch,0,ch2,0,length);

        int indexOfMLen = mLen - 1;
        int indexOfNew = newLen - 1;
        while (indexOfNew > indexOfMLen && indexOfMLen >= 0){
            if (ch2[indexOfMLen] == ' '){
                ch2[indexOfNew--] = '0';
                ch2[indexOfNew--] = '2';
                ch2[indexOfNew--] = '%';
            }else {
                ch2[indexOfNew] = ch2[indexOfMLen];
                indexOfNew--;
            }
            --indexOfMLen;
        }
        return String.copyValueOf(ch2);
    }



    // 方法二：
    public String replaceSpace1(String iniString,int length){
        // 如果允许分配额为空间
        if (iniString == null || iniString.length() <= 0){
            return iniString;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = iniString.charAt(i);
            if (c == ' '){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
