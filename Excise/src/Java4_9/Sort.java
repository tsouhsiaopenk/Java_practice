package Java4_9;

import sun.java2d.pipe.SpanClipRenderer;

import java.util.Arrays;

/*
    以下所有算法均为升序排序
 */
public class Sort {
    // 插入排序
    public static void insertSort(int[] array) {
        // [0,bound)  已排序区间
        // [bound,size) 待排序区间

        // 1.找位置
        for (int bound = 1; bound < array.length; bound++) {
            int v = array[bound];   // 准备处理的元素
            int cur = bound - 1;   // 待排序区间找出的元素
            for (; cur >= 0; cur--) {
                if (array[cur] > v) {
                    array[cur + 1] = array[cur];
                } else {
                    // 说明此时已经找到了合适的位置
                    break;
                }
            }
            // 将bound位置的元素插入进去
            // cur 位置的值比 v 小，所以才退出的循环，因此将cur + 1 位置设置为v
            array[cur + 1] = v;
        }
    }

    // 希尔排序
    public static void shellSort(int[] array) {
        // gap 怎么设计
        int gap = array.length / 2;
        while (gap > 1) {
            insertSortGap(array, gap);
            gap /= 2;
        }
        insertSortGap(array, 1);
    }

    private static void insertSortGap(int[] array, int gap) {
        // 循环处理
        for (int bound = 1; bound < array.length; bound++) {
            int val = array[bound]; // 要处理的一个数字
            int cur = bound - gap;
            for (; cur >= 0; cur = cur - gap) {
                if (array[cur] > val) {
                    array[cur + gap] = array[cur];
                } else {
                    // 已经找到 v 要插入的地方
                    break;
                }
            }
            array[cur + gap] = val;
        }
    }

    // 每次在数组中找到最小的元素放在待排序部分的开头
    public static void selectSort(int[] array) {
        // 循环 length 次，找到每一个位置的需要插入的元素
        for (int bound = 0; bound < array.length; bound++) {
            // 从 bound + 1；开始找最小的元素，然后放在 bound 位置
            for (int cur = bound + 1; cur < array.length; cur++) {
                // 挑选出来的最小元素，需要放在下标为 bound 的位置
                if (array[cur] < array[bound]) {
                    int tmp = array[cur];
                    array[cur] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }

    /*
        堆排序：
            在传进来数组上直接搞一个大堆，然后将堆的第一个和最后一个（当前堆，上一次已经交换的元素除外）交换。
            这样不断重复，就能够从后到前使数组有序。
     */
    public static void swap(int[] array,int a,int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
    public static void heapSort(int[] array) {
        // 1.用传进来的数组建立一个大堆
        createHeap(array,array.length);
        for (int i = 0; i < array.length -1; i++) {
            // 2.将第一个和最后一个（相对）元素交换
            int lastPos = array.length - i;
            swap(array, 0, lastPos);
            lastPos--;
            // 3.将剩余部分重新向下调整使保持堆结构
            shiftDown(array, lastPos,0);
        }
    }

    private static void createHeap(int[] array, int size) {
        // 从后往前对每一个元素进行向下调整
        for (int index = (size - 1 - 1) / 2; index < array.length; index--) {
            shiftDown(array, size, index);
        }
    }

    public static void shiftDown(int[] array, int size, int index) { // 大堆
        // 将需要调整的位置初始化为parent
        int parent = index;
        int child = parent * 2 + 1;
        while (child < size) { // 保证 child 不能越界
            // 使 child 一定是左右孩子中最大的那个
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            // 然后用最大的那个 child 和 parent 比较
            if (array[parent] < array[child]) {
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            } else {
                // 结束
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }

    }


    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 5, 9, 1, 2, 0};
        // insertSort(array);
        // shellSort(array);
        // selectSort(array);
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}


