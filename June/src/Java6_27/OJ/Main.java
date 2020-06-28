package Java6_27.OJ;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            // 学生数目
            int N = scanner.nextInt();
            // 操作数目
            int M = scanner.nextInt();
            // 创建数组来存放学生成绩（舍弃下标为0的地址）
            int[] arr = new int[N + 1];
            for (int i = 1; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i = 0; i < M; i++) {
                char c = scanner.next().charAt(0);
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                // Q 为询问操作，询问id在[A,B]的学生中，成绩最高的是多少
                if (c == 'Q') {
                    int max = 0;
                    for (int j = A; j <= B; j++) {
                        if (max < arr[j]) {
                            max = arr[j];
                        }
                    }
                    System.out.println(max);
                }
                if (c == 'U') {
                    // U 代表更新操作
                    arr[A] = B;
                }
                // operator(arr, c, A, B);
            }
        }
    }

    private static void operator(int[] arr, char c, int A, int B) {
        // Q 为询问操作，询问id在[A,B]的学生中，成绩最高的是多少
        if (c == 'Q') {
            int max = 0;
            for (int i = A; i <= B; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            System.out.println(max);
        } else if (c == 'U') {
            // U 代表更新操作
            arr[A] = B;
        }
    }
}
