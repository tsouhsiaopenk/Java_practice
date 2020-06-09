package Java6_9.OJ;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] strings = s.split(" ");
            int[] arr = new int[strings.length - 1];
            for (int i = 0; i < strings.length - 1; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }
            int k = Integer.parseInt(strings[strings.length - 1]);
            int[] result = new int[k];
            result = topK(arr,k);
            // 依次打印
            for (int i = 0; i < k; i++) {
                System.out.print(result[i] + " ");
            }
        }
    }

    private static int[] topK(int[] arr, int k) {
        // 保存返回的结果集合
        int[] result = new int[k];
        // 默认为升序,不需要自定义比较器
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        for (int i = 0; i <k ; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}
