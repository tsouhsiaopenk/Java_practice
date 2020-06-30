package Java6_27.OJ;


import java.util.Scanner;

/**
 * 此题坑人的地方有两处：
 * 1,不止输入一组n m ;
 * 2,AB之间，可能A>B
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 学生数目
            int N = scanner.nextInt();
            // 操作数目
            int M = scanner.nextInt();
            // 创建数组来存放学生成绩
            int[] stu = new int[N];
            for (int i = 0; i < N; i++) {
                stu[i] = scanner.nextInt();
            }
            for (int i = 0; i < M; i++) {
                String s = scanner.next();
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                // Q 为询问操作，询问id在[A,B]的学生中，成绩最高的是多少
                if (s.equals("Q")) {
                    int left = Math.min(A, B);
                    int right = Math.max(A, B);
                    int max = stu[left- 1];
                    for (int j = left; j < right; j++) {
                        max = Math.max(max, stu[j]);
                    }
                    System.out.println(max);
                }
                if (s.equals("U")) {
                    // U 代表更新操作
                    stu[A - 1] = B;
                }
            }
        }
    }
}
