package Java4_28;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null){
            if (cur.val == val){
                prev.next = cur.next;
                cur = cur.next;
                continue;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.val == val){
            return head.next;
        }
        return head;
    }
}
