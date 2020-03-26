package Java3_26;

public class MyQueueByLinkedList {
    static class Node{
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    // 创建一个链表就得有头节点。此处 head 节点不是傀儡节点
    private Node head = null;
    private Node tail = null;

    // 入队列（尾部插入）
    public void offer(int val){
        Node newNode = new Node(val);
        // 若队列为空
        if (head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        // 队列非空
        tail.next = newNode; 9
        tail = tail.next;
    }

    // 出队列（队首出）
    public Integer poll(){
        // 若当前为空队列
        if (head == null){
            return null;
        }
        // 不是空队列
        int ret = head.val;
        head = head.next;
        if (head == null){
            // 删除当前元素后，队列为空
            tail = null;
        }
        return ret;
    }
    public Integer peek(){
        if (head == null){
            return null;
        }
        return head.val;
    }
}
