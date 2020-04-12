package Java4_12;

import java.util.Arrays;
import java.util.Stack;

public class TestSort {
    /*
        快速排序：借助递归来完成
            1.在待排序区间中找一个基准值（一般为区间的第一个或者最后一个元素）
            2.以基准值为中心，将整个区间整理成三个部分：左侧元素都小于基准值，右侧元素都大于基准值
            3.再次针对左侧和右侧区间，重复以上步骤进行递归
     */
    public static void quickSort(int[] array) {
        // 辅助完成递归过程，这里使用的闭区间
        quickSortHelper(array, 0, array.length - 1);
    }

    // 辅助函数 ： [left , right]
    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            // 此时，区间有 0 或者 1 个元素，不用排序
            return;
        }
        int index = partition(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    /*
        partition 方法做：
            取出一个基准值，让小于基准值的放在基准值左边，大于基准值的放在右边
            并且返回基准值在这样一次调整中的位置
     */
    private static int partition(int[] array, int left, int right) {
        int beg = left;
        int end = right;
        // 取最右侧元素为基准值
        int base = array[right];
        while (beg < end) {
            // 从左往右找比基准值大的元素
            while (beg < end && array[beg] <= base) {
                beg++;
            }
            // 从右往左找比基准值比基准值小的元素
            while (beg < end && array[end] >= base) {
                end--;
            }
            // 执行完上面的步骤，beg 要么和end重合，要么end就指向一个小于base的值
            // 交换beg 和 end 的值
            swap(array, beg, end);
        }
        swap(array, beg, right);
        return beg;
    }

    private static void swap(int[] array, int beg, int end) {
        int tmp = array[beg];
        array[beg] = array[end];
        array[end] = tmp;
    }

    public static void quickSortByLoop(int[] array) {
        // 借助栈来实现递归过程
        Stack<Integer> stack = new Stack<>();
        // 初始情况下，先把左右边界进行入栈（先右后左），左右边界仍然构成前闭后开区间
        stack.push(array.length - 1);
        stack.push(0);

        while (!stack.isEmpty()) {
            // 注意和 push 的顺序正好相反
            int left = stack.pop();
            int right = stack.pop();
            if (left > right) {
                // 区间中只有 1个 或者 0 个
                continue;
            }
            // 通过 partition 把区间整理成以基准值问中心的形式
            int index = partition(array, left, right);
            // [index + 1,right] 基准值右侧区间
            stack.push(right);
            stack.push(index + 1);
            // [left ,index] 基准值左侧区间
            stack.push(index - 1);
            stack.push(left);
        }

    }

    public static void merge(int[] array, int low, int mid, int high) {
        int[] output = new int[high - low];
        int outputIndex = 0;
        int cur1 = low;
        int cur2 = mid;
        while (cur1 < mid && cur2 < high) {
            // 小的先放在 output 数组中
            if (array[cur1] <= array[cur2]) {
                output[outputIndex] = array[cur1];
                outputIndex++;
                cur1++;
            } else {
                output[outputIndex] = array[cur2];
                outputIndex++;
                cur2++;
            }
        }
        // 当上面循环结束的时候，肯定是 cur1 或者 cur2有一个先达到末尾，另一个还剩下一些内容
        // 把剩下的内容拷贝到 output 中
        while (cur1 < mid) {
            output[outputIndex] = array[cur1];
            outputIndex++;
            cur1++;
        }
        while (cur2 < high) {
            output[outputIndex] = array[cur2];
            outputIndex++;
            cur2++;
        }
        for (int i = 0; i < high - low; i++) {
            array[low + i] = output[i];
        }
    }

    public static void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length);
    }

    // 这里使用的是前闭后开区间
    private static void mergeSortHelper(int[] array, int low, int high) {
        if (high - low <= 1) {
            // 两者差值小于等于1表示区间只有 0 个元素或者1个元素
            return;
        }
        int mid = (low + high) / 2;
        mergeSortHelper(array, low, mid);
        mergeSortHelper(array, mid, high);
        merge(array, low, mid, high);
    }
    public static void mergeSortByLoop(int[] array){
        for (int gap = 1; gap <array.length ; gap*=2) {
            for (int i = 0; i < array.length; i+=2*gap) {
                int beg = i;
                int mid = i + gap;
                int end = i + 2*gap;
                if (mid > array.length){
                    mid = array.length;
                }
                if (end > array.length){
                    end = array.length;
                }
                merge(array,beg,mid,end);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{9, 5, 2, 7, 3, 6, 8};
        // quickSort(arr);
        mergeSortByLoop(arr);
        System.out.println(Arrays.toString(arr));
    }
}