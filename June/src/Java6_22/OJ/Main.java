package Java6_22.OJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 查找和排序
 */
class GradeSorted {
    public String name;
    public int grade;

    public GradeSorted(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            // 输入待排序数组长度(要排序的人的个数)
            int toSortedNumber = scanner.nextInt();

            // 输入排序方法（非常重要：上次读题没有看清楚，惨痛教训）
            int orderMethod = scanner.nextInt();
            // 定义一个自定义类的数组，来存放数据
            GradeSorted[] arr = new GradeSorted[toSortedNumber];
            for (int i = 0; i < toSortedNumber; i++) {
                // 输入名字
                String name = scanner.next();
                // 输入分数
                int grade = scanner.nextInt();
                // 放在数组里边
                arr[i] = new GradeSorted(name, grade);
            }
            // 0 是降序 ，1 是升序
            Arrays.sort(arr, new Comparator<GradeSorted>() {
                @Override
                public int compare(GradeSorted o1, GradeSorted o2) {
                    if (orderMethod == 0){
                        // 降序
                        return o2.grade - o1.grade;
                    }
                    return o1.grade - o2.grade;
                }
            });
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i].name + " " + arr[i].grade);
            }
        }
    }
}
