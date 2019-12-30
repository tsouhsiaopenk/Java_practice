import java.util.Arrays;

public class Adjustment {
    /**
     * 调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
     * @param args
     */
    public static int[] adjust(int[] arr){
        int[] result = arr;
        // 初始下标
        int start = 0;
        // 结尾下标
        int end = arr.length-1;
        while(start<end){
            // 从前往后找偶数
            while(start<end&&result[start]%2 != 0){
                start ++;
            }
            // 从后往前找奇数
            while(start<end && result[end]%2 == 0){
                end --;
            }
            int temp = result[start];
            result[start] = result[end];
            result[end] = temp;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6,7,8};
        int[] result = adjust(arr);
        System.out.println(Arrays.toString(result));
    }
}
