package java15_0411;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class testSort {
    public static void quickSort(int[] array) {
        // 辅助完成递归过程
        // 此处为了代码简单, 区间设定成前闭后闭.
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            // 区间中有 0 个元素或者 1 个元素. 此时不需要排序
            return;
        }
        // 针对 [left, right] 区间进行整理
        // index 返回值就是整理完毕后, left 和 right 的重合位置. 知道了这个位置, 才能进一步进行递归
        int index = partition(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int beg = left;
        int end = right;
        // 取最右侧元素为基准值
        int base = array[right];
        while (beg < end) {
            // 从左往右找到比基准值大的元素
            while (beg < end && array[beg] <= base) {
                beg++;
            }
            // 当上面的循环结束时, beg 要么和 end 重合, 要么 beg 就指向一个大于 base 的值

            // 从右往左找比基准值小的元素, 初始情况下, end = right. array[end] 就和 base 相等.
            // 此时要把这个基准值就直接跳过. 始终保持基准值位置就在原位.
            while (beg < end && array[end] >= base) {
                end--;
            }
            // 当上面的循环结束之后, beg 要门和 end 重合, 要么 end 就指向一个小于 base 的值

            // 交换 beg 和 end 的值
            swap(array, beg, end);
        }
        // 当 beg 和 end 重合的时候, 最后一步, 要把重合位置的元素和基准值进行交换
        // [思考] 为啥下面交换了之后, 仍然能满足快排的顺序要求呢?
        // right 这是一个序列中最后的位置. 就要求 beg end 重合位置的元素必须是大于等于基准值的元素, 才可以放到最后面.
        // 如何证明找到的  beg 位置的元素一定 >= 基准值呢?
        // a) beg++ 导致和 end 重合
        //    此时最终的值取决于上次循环中 end 指向的值. 上次循环中, end 应该是找到了一个小于基准值的元素, 然后和一个大于基准值的元素交换了.
        //    此处最终的 end 一定是大于基准值的元素
        // b) end-- 导致和 beg 重合
        //    此时上面 beg++ 的循环退出就一定是因为 beg 位置找到了一个比基准值大的元素, end 和 beg 重合最终元素也一定大于等于基准值.
        swap(array, beg, right);
        return beg;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void quickSortByLoop(int[] array) {
        // 借助栈, 模拟实现递归的过程
        // stack 用来存放数组下标. 通过下标来表示接下来要处理的区间是啥
        Stack<Integer> stack = new Stack<>();
        // 初始情况下, 先把右侧边界下标入栈, 再把左侧边界下标入栈, 左右边界仍然构成前闭后闭区间.
        stack.push(array.length - 1);
        stack.push(0);

        while (!stack.isEmpty()) {
            // 这个取元素的顺序要和push的顺序正好相反
            int left = stack.pop();
            int right = stack.pop();
            if (left >= right) {
                // 区间中只有 1 个或 0 个元素, 不需要整理
                continue;
            }
            // 通过 partition 把区间整理成以基准值为中心, 左侧小于等于基准值, 右侧大于等于基准值的形式
            int index = partition(array, left, right);

            // 准备处理下个区间.
            // [index + 1, right] 基准值右侧区间
            stack.push(right);
            stack.push(index + 1);

            // [left, index - 1] 基准值左侧区间
            stack.push(index - 1);
            stack.push(left);
        }
    }

    // [low, mid)   有序区间
    // [mid, high)  有序区间
    // 把这两个有序区间合并成一个有序区间.
    public static void merge(int[] array, int low, int mid, int high) {
        int[] output = new int[high - low];
        int outputIndex = 0;  // 记录当前 output 数组中被放入多少个元素了
        int cur1 = low;
        int cur2 = mid;

        while (cur1 < mid && cur2 < high) {
            // 这里写成 <= 才能保证稳定性.
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
        // 当上面的循环结束的时候, 肯定是 cur1 或者 cur2 有一个先到达末尾, 另一个还剩下一些内容
        // 把剩下的内容都一股脑拷贝到 output 中
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

        // 把output中的元素再搬运回原来的数组
        for (int i = 0; i < high - low; i++) {
            array[low + i] = output[i];
        }
    }

    public static void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length);
    }

    // [low, high) 前闭后开区间, 两者差值小于等于 1, 区间中就只有 0 个元素或者 1 个元素
    private static void mergeSortHelper(int[] array, int low, int high) {
        if (high - low <= 1) {
            return;
        }
        int mid = (low + high) / 2;
        // 这个方法执行完, 就认为 low, mid 已经排序ok
        mergeSortHelper(array, low, mid);
        // 这个方法执行完, 就认为, mid, high 也已经排序ok
        mergeSortHelper(array, mid, high);

        // 当把左右区间已经归并排序完了, 说明左右区间已经是有序区间了.
        // 接下来就可以针对两个有序区间进行合并了.
        merge(array, low, mid, high);
    }

    public static void mergeSortByLoop(int[] array) {
        // 引入一个 gap 变量进行分组
        // 当 gap 为 1 的时候, [0, 1) [1, 2) 进行合并, [2, 3) [3, 4) 进行合并, [4, 5) [5, 6) 进行合并, [6, 7) [7, 8) 进行合并.....
        // 当 gap 为 2 的时候, [0, 2) 和 [2, 4) 进行合并, [4, 6) 和 [6, 8) 进行合并
        // 当 gap 为 4 的时候, [0, 4) 和 [4, 8) 进行合并...
        for (int gap = 1; gap < array.length; gap *= 2) {
            // 接下来进行具体的分组合并
            // 下面的循环执行一次, 就完成了一次相邻两个组的合并
            for (int i = 0; i < array.length; i += 2*gap) {
                // 当前相邻组
                // [beg, mid)
                // [mid, end)
                int beg = i;
                int mid = i + gap;
                int end = i + 2*gap;
                // 防止下标越界
                if (mid > array.length) {
                    mid = array.length;
                }
                if (end > array.length) {
                    end = array.length;
                }
                merge(array, beg, mid, end);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        // quickSort(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
