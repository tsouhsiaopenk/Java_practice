package Java4_20;


/*
不使用任何内建的哈希表库设计一个哈希集合
具体地说，你的设计应该包含以下的功能
    add(value)：向哈希集合中插入一个值。
    contains(value) ：返回哈希集合中是否存在这个值。
    remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 */
class MyHashSet {
    // 使用链表来实现
    static class Node{
        int key;
        Node next;

        public Node(int val) {
            this.key = val;
        }
    }
    public Node head;
    /** Initialize your data structure here. */
    public MyHashSet() {
        head = null;
    }

    public void add(int key) {
        // 插入的过程中需要判断是否重复,我们先写contains方法
        if (contains(key)){
            // 重复了，不用继续
            return;
        }
        // 头插法
        Node newNode = new Node(key);
        newNode.next = head;
        head = newNode;
    }
    // 删除
    public void remove(int key) {
        if (head == null){
            return;
        }
        Node cur = head.next;
        Node parent = head;
        if (parent.key == key){
            head = head.next;
        }
        while (cur != null){
            if (cur.key == key){
                parent.next = cur.next;
                return;
            }else{
                parent = cur;
                cur = cur.next;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        Node cur = head;
        while (cur != null){
            if (cur.key == key){
                return true;
            }else {
                cur = cur.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
