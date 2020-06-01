package Java6_1;

import org.junit.Test;

import java.io.*;

public class FileIOTest {
    @Test
    public void t1() throws IOException {
        FileReader reader = new FileReader("C:\\Users\\zxp\\Desktop\\Programming\\Java_practice\\June\\data\\随便.txt");
        char[] chars = new char[1024];
        int len;
        while ((len = reader.read(chars)) != -1){
            String s = new String(chars,0,len);
            System.out.println(s);
        }
    }

    @Test
    public void  t2() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\zxp\\Desktop\\Programming\\Java_practice\\June\\data\\随便.txt");
        // 字节字符转换流，指定编码格式
        // Java编译的编码如果和目标文件的编码格式不一致，就会出现乱码
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");// 这里不能使用GBK
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
    }

    @Test
    public void t() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\zxp\\Desktop\\Programming\\Java_practice\\June\\data\\随便.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1){
            String s = new String(bytes,0,len);
            System.out.println(s);
        }
    }

}
