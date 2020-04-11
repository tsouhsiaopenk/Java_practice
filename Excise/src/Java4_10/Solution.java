package Java4_10;

import java.util.Arrays;

public class Solution {
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int cur = array.length - 1; cur > i; cur--) {
                if (array[cur] < array[cur - 1]) {
                    int tmp = array[cur];
                    array[cur] = array[cur - 1];
                    array[cur - 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,5,2,7,3,6,8};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
