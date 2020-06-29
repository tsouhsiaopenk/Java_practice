package Java6_29.OJ;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 输入总的课程数 n(n<10)
            int n = scanner.nextInt();
            // 相应课程的学分
            int[] courseCredit = new int[n];
            for (int i = 0; i < n; i++) {
                courseCredit[i] = scanner.nextInt();
            }
            // 对应课程的实际得分
            int[] score = new int[n];
            for (int i = 0; i < n; i++) {
                score[i] = scanner.nextInt();
            }
            double GPA = calculateGPA(courseCredit, score);
            System.out.printf("%.2f", GPA);
            System.out.println(GPA);
        }
    }

    // 计算GPA
    private static double calculateGPA(int[] courseCredit, int[] score) {
        // 学分绩点和，不是绩点（题目真是见鬼，这都不说清楚）
        double pointSum = 0;
        // 所有课程学分和
        double gradeSum = 0;
        for (int i = 0; i < courseCredit.length; i++) {
            pointSum += getPoint(score[i])*courseCredit[i];
            gradeSum += courseCredit[i];
        }
        return pointSum / gradeSum;
    }

    // 根据成绩来计算绩点
    private static double getPoint(int score) {
        if (score <= 100 && score >= 90) {
            return 4.0;
        }else if (score <= 89 && score >= 85){
            return 3.7;
        }else if (score <= 84 && score >= 82){
            return 3.3;
        }else if (score <= 81 && score >= 78){
            return 3.0;
        }else if (score <= 77 && score >= 75){
            return 2.7;
        }else if (score <= 74 && score >= 72){
            return 2.3;
        }else if (score <= 71 && score >= 68){
            return 2.0;
        }else if (score <= 67 && score >= 64){
            return 1.5;
        }else if (score <= 63 && score >= 60){
            return 1.0;
        }// 60 分以下是 0，不是0.1，别看错了
        return 0;
    }
}
