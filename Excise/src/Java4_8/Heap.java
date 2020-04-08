package Java4_8;

import java.util.Arrays;

public class Heap {
    // 我们在此处以大堆为例来，来向下调整
    /*
     * array[] 要调整的数组
     * size 指定哪些是堆的有效元素
     * index 要调整的下标
     * */
    public static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1; // 初始化为左子树的节点
        while (child < size) {
            // 比较左右子树，找到最大值
            if (child + 1 < size && array[child] < array[child + 1]) {
                child = child + 1;
            }
            // 比较 parent 和 child
            if (array[parent] < array[child]) {
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            } else {
                break;// 调整结束
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public static void creatHeap(int[] array, int size) {
        // 从后往前遍历数组
        for (int i = (size - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, size, i);
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        creatHeap(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
