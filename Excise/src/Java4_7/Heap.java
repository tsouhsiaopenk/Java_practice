package Java4_7;

import java.util.Arrays;

// 以小堆为例
public class Heap {
    /*
        通过 size 指定 Array 中哪些元素是有效的堆元素
        index 表示 从那个位置的下标开始调整的
        左右子树都是堆，才能进行这样的调整
     */
    public static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        // 根据 parent 的下标 找到左子树的下标
        int child = 2 * parent + 1;
        // 若 child 已经是叶子节点，则结束调整
        while (child < size) {
            // 比较左右子树，找到较小值
            if (child + 1 < size && array[child + 1] < array[child]) {
                child = child + 1;
            }
            // 比较 child 位置的元素和 parent 位置的元素
            if (array[child] < array[parent]) {
                // 若 array[child] < array[parent 不符合小堆的规则，进行交换
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            } else {
                // 结束调整
                break;
            }
            // 更新 parent 和 child，处理下一层的数据
            parent = child;
            child = parent * 2 + 1;
        }
    }

    public static void createHeap(int[] array, int size) {
        // 从后往前调整
        for (int i = (size - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, size, i);
        }
    }

    public static void main(String[] args) {
        int [] array = {3,7,1,8,0,2,6};
        createHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}
