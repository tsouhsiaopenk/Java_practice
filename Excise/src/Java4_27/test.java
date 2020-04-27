package Java4_27;
public class test {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode reverse(ListNode head){
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode newListNode = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            if (next == null){
                newListNode = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return newListNode;
    }
}
