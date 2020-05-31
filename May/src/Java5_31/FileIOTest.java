package Java5_31;

import com.sun.javafx.logging.JFRInputEvent;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileIOTest {
    @Test
    public void t1() throws IOException {
        InputStream fis = null;
        try {
            // 方法一：使用FileInputStream + 绝对路径
            fis = new FileInputStream("C:\\Users\\zxp\\Desktop\\Programming\\Java_practice\\May\\data\\随便.txt");

            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                String s = new String(bytes, 0, len);
                System.out.println(s);
            }
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }

    @Test
    public void t2() {
        File f = new File(".");
        String absolutePath = f.getAbsolutePath();
        System.out.println(absolutePath);
    }

    @Test
    public void t3() {
        System.out.println(File.separator);
    }

    public static void listAllFiles(File file) {
        // 保证是个目录且存在
        if (file.exists() && file.isDirectory()) {
            File[] result = file.listFiles();
            if (result != null) {
                for (File file1 : result) {
                    listAllFiles(file1);
                }
            }
        } else {
            // 给定的file是文件，直接打印
            System.out.println(file);
        }
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\zxp\\Desktop\\Programming\\Java_practice\\May");
        listAllFiles(file);
    }
}
