import java.util.Arrays;

public class ArrayEnc {
    /*
        实现一个方法 toString, 把一个整型数组转换成字符串. 例如数组 {1, 2, 3} , 返回的字符串为 "[1, 2, 3]", 注意 逗号 的位置和数量.
        实现一个方法 copyOf, 对一个整型数组进行拷贝, 得到一个新的数组.
        给定一个有序整型数组, 实现二分查找
        给定一个整型数组, 判定数组是否有序
        给定一个整型数组, 实现冒泡排序(升序排序)
     */

    public static int binararySearch(int[] arr, int tofind) {
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            if (tofind == arr[mid]) {
                return mid;
            }
            if (tofind < arr[mid]) {
                // 左边查找
                right = mid - 1;
                mid = (left + right) / 2;
            }
            if (tofind > arr[mid]) {
                // 右边查找
                left = mid + 1;
                mid = (left + right) / 2;
            }
        }
        return -1;
    }

    public static int[] copyOf(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static String toString(int[] arr) {
        String string = "[";
        for (int i = 0; i < arr.length; i++) {
            string = string + arr[i];
            if (i != arr.length - 1) {
                string = string + ",";
            }
        }
        string = string + "]";
        return string;
    }

    public static boolean isOrder(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void bubbleSort(int[] arr) {
        for (int bound = 0; bound < arr.length;bound++ ){
            for (int cur = arr.length-1;cur>bound;cur--){
                if(arr[cur-1]>arr[cur]){
                    int temp = arr[cur-1];
                    arr[cur-1] = arr[cur];
                    arr[cur] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7};
        //System.out.println(binararySearch(arr,7));
        //System.out.println(isOrder(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
  写代码: 创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
  编写代码: 实现一个方法 printArray, 以数组为参数, 循环访问数组中的每个元素, 打印每个元素的值.
  编写代码: 实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2 , 并设置到对应的数组元素上. 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
  编写代码: 实现一个方法 sum, 以数组为参数, 求数组所有元素之和.
  编写代码: 实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型).
   */
    public static double avg(int[] arr) {
        double result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result += arr[i];
        }
        return result / arr.length;
    }

    public static int sum(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void transform(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }
}
