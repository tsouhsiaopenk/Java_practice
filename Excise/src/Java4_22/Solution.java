package Java4_22;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    // 反转一个单链表
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        // 如果链表为空，不用反转了
        if (head == null){
            return null;
        }
        // 如果只有一个元素，也就不用反转
        if (head.next == null){
            return head;
        }
        // 进行反转
        ListNode preNode = null;
        ListNode cur = head;
        ListNode newHead = null;
        while(cur != null){
            ListNode next = cur.next;
            if (next == null){
                newHead = cur;
            }
            cur.next = preNode;
            // 更新
            preNode = cur;
            cur = next;
        }
        return newHead;
    }
}


//            if (cur != null && cur.next != null){
//                ListNode posNode = cur.next;
//                posNode.next = cur;
//                cur.next = preNode;
//            }
