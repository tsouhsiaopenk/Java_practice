package Java6_18.Oj;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            // 读入学生人数
            int N = scanner.nextInt();
            int[] scores = new int[N];
            // 读入 N 个学生的成绩
            for (int i = 0; i < N; i++) {
                scores[i] = scanner.nextInt();
            }
            // 给定分数
            int key = scanner.nextInt();
            // 找到给定分数的人数
            int num = getNum(scores,key);
            // 输出
            System.out.println(num);
        }
    }

    // 求出给定分数的学生人数：这里直接遍历即可（也可以使用map）
    private static int getNum(int[] scores, int key) {
        int num = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == key){
                num++;
            }
        }
        return num;
    }
}
