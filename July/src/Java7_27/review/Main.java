package Java7_27.review;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Main {
    // 从小到大
    public static void bubbleSort(int[] arr) {
        // [0,bound)已排序区间
        // [bound,arr.length) 待排序区间
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = arr.length - 1; cur > bound; cur--) {
                if (arr[cur - 1] > arr[cur]) {
                    int tmp = arr[cur - 1];
                    arr[cur - 1] = arr[cur];
                    arr[cur] = tmp;
                }
            }
        }
    }

    @Test
    public void TestBubbleSort() {
        int[] arr = {9, 5, 2, 7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
