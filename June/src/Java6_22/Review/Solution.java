package Java6_22.Review;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 输入火车数量
            int n = scanner.nextInt();
            // 输入火车编号
            int[] trains = new int[n];
            for (int i = 0; i < n; i++) {
                trains[i] = scanner.nextInt();
            }
            int start = 0;
            // 计算n个火车的出栈的编号的排列组合
            ArrayList<int[]> result = new ArrayList<int[]>();
            Permutation(trains, start, n, result);
            // 出栈的结果，一个元素一个记录，例如：1，2，3； 1 2 3
            Set<String> sortResult = new TreeSet<String>();
            // 循环排列组合
            for (int[] out : result) {
                // 判断是否满足出栈要求（后进先出）
                if (isLegal(trains, out, n)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < n - 1; i++) {
                        sb.append(out[i] + " ");
                    }
                    sb.append(out[n - 1]);
                    sortResult.add(sb.toString());
                }
            }
            // 最后输出所有的符合出栈要求的组合
            for (String list : sortResult) {
                System.out.println(list);
            }
        }
    }

    private static boolean isLegal(int[] in, int[] out, int n) {
        // 栈：存储进站的火车编号
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (i < n) { // in 还有元素的时候都需要判断
            if (in[i] == out[j]){
                i++;
                j++;
            }else {
                if (stack.isEmpty()){// 空栈就只有入栈了
                    stack.push(in[i]);
                    i++;
                }else{
                    int top = stack.peek(); // 栈顶元素相等，进行出栈
                    if (top == out[j]){
                        j++;
                        stack.pop();
                    }else if (i < n){
                        stack.push(in[i]);
                        i++;
                    }
                }
            }
        }
        while (!stack.isEmpty() && j<n){
            // in的结束后，栈中元素进程出栈序列应该和out剩余
            int top = stack.pop();
            if (top == out[j]){
                j++;
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * 求出所有排列
     *
     * @param trains 存储火车序列的数组
     * @param start
     * @param n
     * @param result 将结果放在result中
     */
    private static void Permutation(int[] trains, int start, int n, ArrayList<int[]> result) {
        if (start == n) {
            return;
        }
        if (start == n - 1) {
            int[] B = trains.clone();
            result.add(B);
            return;
        }
        for (int i = start; i < n; i++) {
            swap(trains, start, i);
            Permutation(trains, start + 1, n, result);
            swap(trains, start, i);
        }
    }

    private static void swap(int[] trains, int i, int j) {
        int tmp = trains[i];
        trains[i] = trains[j];
        trains[j] = tmp;
    }

}

