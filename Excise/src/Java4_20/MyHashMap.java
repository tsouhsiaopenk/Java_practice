package Java4_20;

// 通过开散列的方式来处理 hash 冲突
public class MyHashMap {
    static class Node {
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final double LOAD_FACTOR = 0.75;

    // array 就是 hash 表,数组中每个元素优势一个链表的头节点
    private Node[] array = new Node[101];
    // 表示当前 hash 表中元素个数
    private int size = 0;

    // 实际可能更加复杂
    private int hashFunc(int key) {
        return key % array.length;
    }

    public void put(int key, int value) {
        // 1.把 key 映射成数组下标
        int index = hashFunc(key);
        // 2.根据下标找到对应的链表
        Node list = array[index];
        // 3.当前 key 是否在链表中存在
        for (Node cur = list; cur != null; cur = cur.next) {
            if (cur.key == key) {
                // key 已经存在，直接修改 value 即可
                cur.value = value;
                return;
            }
        }
        // 4.如果循环结束后还没有找到 key 结点，直接插入
        // 这里使用头插法
        Node newNode = new Node(key, value);
        newNode.next = list;
        array[index] = newNode;
        // 元素个数加一
        size++;

        // 扩容操作
        if (size / array.length > LOAD_FACTOR) {
            resize();
        }
    }

    private void resize() {
        Node[] newArray = new Node[2 * array.length];
        for (int i = 0; i < array.length; i++) {
            for (Node cur = array[i]; cur != null; cur = cur.next) {
                int index = cur.key % newArray.length;
                Node newNode = new Node(cur.key, cur.value);
                newNode.next = newArray[index];
                newArray[index] = newNode;
            }
        }
        array = newArray;
    }

    public int get(int key) {
        // 1.先计算出 key 对应的下标
        int index = hashFunc(key);
        // 2.根据下标找到对应的链表
        Node list = array[index];
        // 3.在链表中查找指定元素
        for (Node cur = list;cur != null;cur = cur.next){
            if (cur.key == key){
                return cur.value;
            }
        }
        return -1;
    }

    public void remove(int key){
        if (get(key) == -1){
            return;
        }
        // 1.先计算出 key 对应的下标
        int index = hashFunc(key);
        // 2.根据下标找到对应的链表
        Node list = array[index];
        // 3.在链表中查找指定元素
        Node preNode  = list;
        Node cur = list.next;
        if (preNode.key== key){
            list = list.next;
            array[index] = list;
        }
        while (cur != null){
            if (cur.key == key){
                preNode = cur.next;
                array[index] = list;
                return;
            }else {
                preNode = cur;
                cur = cur.next;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1,1);
        hashMap.put(2,2);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));
        hashMap.put(2,1);
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));
    }
}
