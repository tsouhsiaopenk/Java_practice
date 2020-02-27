package Java1_19;

class Node {
    public int data;//数据
    public Node next = null;//下一个节点位置

    public Node(int data) {
        this.data = data;
    }
}

public class LinkedList {
    private Node head = null;

    //头插法
    public void addFirst(int data) {
        // 创建一个节点
        Node node = new Node(data);
        // 将节点加入到链表中
        if (head == null) {
            head = node;
            return;
        }
        node.next = head.next;
        head = node;
    }

    //尾插法
    public void addLast(int data) {
        // 创建一个节点
        Node node = new Node(data);
        // 若链表为空
        if (head == null) {
            head = node;
            return;
        }
        // 若链表非空,先通过遍历找到最后一个节点
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        // 找到最后一个节点后，将需要尾插的元素链接在后边
        tail.next = node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index, int data) {
        // 先判断插入位置是否有效
        int size = getSize();
        if (index < 0 || index > size) {
            // index 无效，插入失败
            return false;
        }
        // 若 index 为0，则相当于头插
        if (index == 0) {
            addFirst(data);
            return true;
        }
        // 若 index 为 size，则相当于尾插
        if (index == size) {
            addLast(data);
            return true;
        }
        // 如果 index 只是链表中间的一个任意位置
        Node node = new Node(data);
        // 找到 index 之前的一个节点 index-1;
        Node prev = getPos(index - 1);
        // 将新建要插入的节点接在prev之后，其余诸节点接在新建节点后
        node.next = prev.next;
        prev.next = node;
        return true;
    }

    private Node getPos(int index) {
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.data == key) {
                return true;
            }
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        // 若为头节点
        if (head.data == key) {
            head = head.next;
            return;
        }
        // 若不是头节点，找到要删除节点的前一个节点
        Node prev = searchPrev(key);
        // 修改节点关系，完成修改
        prev.next = prev.next.next;
    }

    private Node searchPrev(int tomove) {
        // 找到 toRemove 的前一个元素
        for (Node cur = head; cur != null && cur.next != null; cur = cur.next) {
            if (cur.next.data == tomove) {
                return cur;
            }
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        // 先删除非头节点
        Node prev = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.data == key) {
                // 删除cur节点
                prev.next = cur.next;
                cur = prev.next;
            } else {
                // prev 和 cur 同步往后移动
                prev = cur;
                cur = cur.next;
            }
        }
        // 删除头节点的情况
        if (head.data == key) {
            head = head.next;
        }
    }

    //得到单链表的长度
    public int getSize() {
        int size = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    public void display() {
        // 打印链表中的每一个元素
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        // 换行
        System.out.println();
    }

    public void clear() {
        head = null;
    }

}
