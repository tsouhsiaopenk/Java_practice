package Java4_8;

public class MyPriorityQueue {
    // 以大堆为例子
    private int[] array = new int[100];
    private int size = 0;

    public void offer(int val) {
        array[size] = val;
        size++;
        // 把新加入的元素进行向上调整
        shiftUp(array, size - 1);
    }

    private static void shiftUp(int[] array, int index) {
        int child = index;
        int parent = (index - 1) / 2;
        while (child > 0) {
            if (array[parent] < array[child]) {
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            } else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    // 将队首元素删掉并返回，同时保持堆结构
    public int poll() {
        int result = array[0];
        array[0] = array[size - 1];
        size--;
        shiftDown(array, size, 0);
        return result;
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child] < array[child + 1]) {
                child = child + 1;
            }
            if (array[parent] < array[child]) {
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public int peek(){
        return array[0];
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            System.out.print(cur + " ");
        }
    }
}
