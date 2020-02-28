package Java2_28;

public class Solution1 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    // 反转单链表
    public ListNode reverseList(ListNode head) {
        // 空链表不需要逆置
        if (head == null){
            return null;
        }
        // 只有一个元素，也不需要逆置
        if (head.next == null){
            return head;
        }
        ListNode newHead = null;
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode next = cur.next;
            if (next == null){
                newHead = cur;
            }
            // 逆置操作
            cur.next = prev;
            // 更新操作
            prev = cur;
            cur = next;
        }
        return newHead;
    }
}
