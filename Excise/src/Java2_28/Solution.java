package Java2_28;


public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /*
    *
    * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
    如果有两个中间结点，则返回第二个中间结点。
 */
    public ListNode middleNode(ListNode head) {
        // 先排除特殊情况
        if (head == null) {
            return null;
        }
        int size = Size(head);
        for (int i = 0; i < size / 2; i++) {
            head = head.next;
        }
        return head;
    }

    private int Size(ListNode pHead) {
        if (pHead == null) {
            return 0;
        }
        int size = 0;
        while (pHead != null) {
            size++;
            pHead = pHead.next;
        }
        return size;
    }
}
