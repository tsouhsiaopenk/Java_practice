package Java2_27;

public class Solution1 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    /*
           将两个有序链表合并为一个新的有序链表并返回。
           新链表是通过拼接给定的两个链表的所有节点组成的。
    */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 先排除极端情况
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 创建一个新的链表，表示合并后的链表
        ListNode newListNode = new ListNode(-1);
        ListNode newTail = newListNode;
        // 1,l1 和 l2 都不为空的情况
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                ListNode newNode = new ListNode(cur1.val);
                newTail.next = newNode;
                newTail = newTail.next;
                cur1 = cur1.next;
            } else {
                ListNode newNode = new ListNode(cur2.val);
                newTail.next = newNode;
                newTail = newTail.next;
                cur2 = cur2.next;
            }
        }
        // 2, l1 和 l2 中至少有一个为空 （l1为空 ，l2为空，l1和l2都为空）
        if (l1 == null) {
            newTail.next = cur2.next;
        }
        if (l2 == null) {
            newTail.next = cur1.next;
        }
        return newListNode.next;
    }

}
