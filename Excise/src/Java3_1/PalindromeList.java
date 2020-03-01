package Java3_1;

import java.util.List;

public class PalindromeList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public boolean chkPalindrome(ListNode A) {
        // write code here
        // 先找到链表的中间节点
        // 链表的长度
        int size = Size(A);
        // 步数
        int steps = size / 2;
        ListNode B = A;
        for (int i = 0; i < steps; i++) {
            B = B.next;
        }
        // 将 链表B 进行 反转
        ListNode prev = null;
        ListNode cur = B;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                // 此时已经是最后一个节点，需要更新头节点
                B = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        while(A != null){
            if (A.val != B.val){
                return false;
            }
            A = A.next;
            B = B.next;
        }
        return true;
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
