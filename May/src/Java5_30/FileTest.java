package Java5_30;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTest {
    /*
         文件的相对路径 和 绝对路径？
         绝对路劲：全路径
         相对路劲：./(当前目录)， ../(上一级目录)
     */

    /*
        Java项目在idea中的编译路径
     */
    @Test
    public void t1() {
        File file = new File("C:\\Users\\zxp\\Desktop\\Programming\\Java_practice\\May\\data\\随便.txt");
        System.out.println(file.exists());
        File f2 = new File("../data/随便.txt");
        System.out.println(f2.exists()); // 打印结果为false，为什么？
        // 怎么查看当前Java代码的路径
        File f3 = new File("");
        System.out.println(f3.getAbsolutePath()); // 获取绝对路径
        // file类写相对路径不建议在实际的项目中使用
        File f4 = new File("data/随便.txt");
        System.out.println(f4.exists()); // 文件是否存在

        System.out.println(f4.getPath()); // 获取路径
        System.out.println(f4.lastModified());  // 上次修改时间
    }

    @Test
    public void t2() {
        File f5 = new File("C:\\Users\\zxp\\Desktop\\materials\\比特");
        File[] children = f5.listFiles();
        for(File child:children){
            System.out.println(child.getName());
        }
    }

    // 递归获取目录下所有的子文件和子文件夹
    public static List<File> list(File f){
        List<File> files = new ArrayList<>();
        if (f.exists())
            files.add(f);
        else {
            File[] children = f.listFiles();
            for (File child:children){
                List<File> subs = list(child);
                files.addAll(subs);
            }
        }
        return files;
    }

    @Test
    public void t3(){
        File f5 = new File("C:\\Users\\zxp\\Desktop\\materials\\比特");
        List<File> children = list(f5);
        for(File child:children){
            System.out.println(child.getName());
        }
    }
}
