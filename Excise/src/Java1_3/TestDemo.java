package Java1_3;

import java.util.Arrays;

public class TestDemo {
    public void changeArray(int[] arr1, int[] arr2) {
        // 给定两个整型数组, 交换两个数组的内容.
        for (int i = 0; i < arr1.length; i++) {
            int temp = arr1[i];
            arr1[i] = arr2[i];
            arr2[i] = temp;
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void userSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            // 找第一个奇数
            while (left < right && arr[left] % 2 == 0) {
                left++;
            }
            // 找第一个偶数
            while (left < right && arr[right] % 2 != 0) {
                right--;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5,0, 2, 4, 6, 8 ,7, 9};
        userSort(arr1);
        System.out.println(Arrays.toString(arr1));
        // 给定整型数组, 把所有的偶数放到数组前面, 把所有奇数放到数组后面.
    }
}
