package Java2_27;

public class Solution2 {
    static class ListNode {
        int val;
        Solution.ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    /*
     * 输入一个链表，输出该链表中倒数第k个结点。
     * */
    public Solution.ListNode FindKthToTail(Solution.ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = Size(head);
        if (k < 0 || k > size) {
            // k 不合法
            return null;
        }
        // 链表需要往后走steps步数才能找到
        int steps = size - k;
        Solution.ListNode kNode = head;
        for (int i = 0; i < steps; i++) {
            kNode = kNode.next;
        }
        return kNode;
    }

    private int Size(Solution.ListNode pHead) {
        int size = 0;
        if (pHead == null) {
            return 0;
        }
        while (pHead != null) {
            size++;
            pHead = pHead.next;
        }
        return size;
    }
}
