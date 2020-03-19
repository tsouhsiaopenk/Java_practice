package Java3_19;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\zxp\\Desktop\\数据挖掘作业\\lorenza.dat");
        FileInputStream fis = null;
        BufferedReader br = null;
        List<String> list = new ArrayList<>();
        try {
            fis = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        double[] a = new double[128];
        int cur = 0;
        for (String s : list) {
            if (cur < 128) {
                a[cur] = Double.valueOf(s);
            }
            cur++;
        }

        for (int i = 0; i < 128; i++) {
            System.out.println(a[i]);
        }
    }

}
