package Java7_6.OJ;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Record {
    // 文件名
    public String fileName;
    // 错误所在代码行
    public int row;
    // 错误数目
    public int errorNum = 1;

    public Record(String fileName, int row) {
        this.fileName = fileName;
        this.row = row;
    }

    public void setErrorNum() {
        this.errorNum++;
    }

    @Override
    public boolean equals(Object another) {
        if (another == null){
            return false;
        }
        if (another instanceof Record){
            Record anotherRecord = (Record) another;
            return this.fileName.equals(anotherRecord.fileName) && this.row == anotherRecord.row;
        }
        return false;
    }
}

public class Solution {
    public static void main(String[] args) {
        // 错误记录列表，必须定义在外边
        List<Record> list = new LinkedList<>();
        // 输入操作
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 输入文件路径
            String filePath = scanner.next();
            // 输入错误行数
            int row = scanner.nextInt();

            String[] strings = filePath.split("\\\\");
            String fileName = strings[strings.length - 1];

            Record newRecord = new Record(fileName, row);
            // 如果错误列表中已经有了，就把错误次数加一 ， 这里需要重写equals方法
            if (list.contains(newRecord)){
                int index = list.indexOf(newRecord);
                list.get(index).setErrorNum();
            }else{
                list.add(newRecord);
            }
        }

        // 逆序：由大到小
        list.sort(new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o2.errorNum - o1.errorNum;
            }
        });
        // 只输出前八个
        int bound = Math.min(8, list.size());
        for (int i = 0; i < bound; i++) {
            // 如果文件名超过16个字符，则只输出后16个字符
            String fN = list.get(i).fileName;
            if (fN.length() > 16){
                fN = fN.substring(fN.length()-16);
            }
            // 打印输出的两种方法
            System.out.println(fN + " " + list.get(i).row + " " + list.get(i).errorNum);
            // System.out.printf("%s %s %d%n", fN, list.get(i).row, list.get(i).errorNum);
        }
    }

}
