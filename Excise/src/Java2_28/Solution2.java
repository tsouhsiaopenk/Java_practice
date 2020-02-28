package Java2_28;

public class Solution2 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        // 特殊情况
        if (head == null) {
            return null;
        }
        // 先删除中间结点以外的结点
        ListNode prev = head; // prev 是 cur 前面的一个元素
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val){
                // 需要删除的结点
                prev.next = cur.next;
                cur = cur.next;
            }else {
                // 不需要删除的结点
                prev = prev.next;
                cur = cur.next;
            }
        }
        // 再删除头结点
        if (head.val == val){
            head = head.next;
        }
        return head;
    }
}
