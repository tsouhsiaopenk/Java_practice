package Java3_1;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class Solution1 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 先求出两个链表的长度
        int sizeA = Size(headA);
        int sizeB = Size(headB);
        // 计算两个链表的差值
        int offset = sizeA > sizeB ? sizeA : sizeB;
        if (sizeA > sizeB) {
            for (int i = 0; i < offset; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < offset; i++) {
                headB = headB.next;
            }
        }
        // 此时 headA 和 headB 的长度应该是一致的
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        // 链表不相交
        return null;
    }

    private int Size(ListNode head) {
        int size = 0;
        if (head == null) {
            return 0;
        }
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
