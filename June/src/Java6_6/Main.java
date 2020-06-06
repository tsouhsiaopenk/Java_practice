package Java6_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            // 第一行输入不同的物品数目
            int thingsNumber = scanner.nextInt();
            // 接下来的 thingsNumber 行输入物品的体积
            int[] volumes = new int[thingsNumber];
            for (int i = 0; i < thingsNumber; i++) {
                volumes[i] = scanner.nextInt();
            }
            // 输出不同的选择物品的方式的数目
            int result = listCombination(volumes);
            System.out.println(result);
        }
    }

    private static int listCombination(int[] volumes) {
        // 1.组合：列出所有体积组合
        List<List<Integer>> com = sub(volumes);
        // 2.计算组合中总体积为 40 的数目
        int count = 0;
        for (int i = 0; i < com.size(); i++) {
            // 计算每个 List<Integer> 中的和
            int sum = listSum(com.get(i));
            if (sum == 40) {
                count++;
            }
        }
        return count;
    }


    private static int listSum(List<Integer> integers) {
        int sum = 0;
        for (Integer i : integers) {
            sum += i;
        }
        return sum;
    }

    /*
        组合算法:
            传入参数：int[] arr:在本题目中表示为所物品的体积
     */
    public static List<List<Integer>> sub(int[] arr) {
        // 返回的结果数组
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // 循环 arr.length 次数 , 外层循环的每一次都在内层循环中创建出 i 个物品组合的 List 组合
        for (int i = 1; i <= arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                List<Integer> list = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    list.add(arr[k]);
                }
                result.add(list);
            }
        }
        return result;
    }
}
