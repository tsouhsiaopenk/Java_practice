package Java5_10;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode prev = head;
        ListNode cur = head.next;
        if (prev.val == val) {
            return cur;
        }
        while (cur.val != val && cur != null) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        return head;
    }
}
