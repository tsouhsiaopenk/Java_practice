package Java7_12.OJ;

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
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < getLen(head) - k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private int getLen(ListNode head) {
        int num = 0;
        while (head != null) {
            head = head.next;
            num++;
        }
        return num;
    }
}
