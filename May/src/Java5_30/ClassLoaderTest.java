package Java5_30;

import org.junit.Test;

import java.io.*;

public class ClassLoaderTest {
    @Test
    public void t1(){
        // 通过class获取资源或者IO流：以当前class编译类的路径最为相对的位置
        InputStream is = this.getClass().getResourceAsStream("../随便.txt");
        System.out.println(is);
        // 通过classLoader获取资源或者IO流：以整个项目编译的根路径作为相对路径
        // 项目通过相对路径获取资源文件时，一般使用获取ClassLoader
        // 获取，不使用class和File
        InputStream is2 = this.getClass().getClassLoader().getResourceAsStream("随便.txt");
        System.out.println(is2);
    }

    @Test
    public void t2() throws IOException {
        File file = new File("随便.txt");
        InputStream fileInputStream = this.getClass().getClassLoader().getResourceAsStream("随便.txt");
        File file1 = new File("E:\\test.txt");
        if (!file1.exists()){
            file1.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\test.txt");
        int len = 0;
        byte[] buff = new byte[1024];
        while ((len = fileInputStream.read(buff))!=-1){
            fileOutputStream.write(buff,0,len);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}