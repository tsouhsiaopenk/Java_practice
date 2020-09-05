package Java6_25.OJ;

import org.junit.Test;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Plus {
    // 链表 加法
    public ListNode plusAB(ListNode a, ListNode b) {
        // 表示进位
        int carry = 0;
        // 当前位的值
        int current = 0;
        // 用一个带有傀儡结点的链表的存放结果
        ListNode cur = new ListNode(-1);
        ListNode result = cur;
        ListNode curA = a;
        ListNode curB = b;
        while (curA != null && curB != null) {
            // 当前位置要做的是本位数字的和加上进位的结果
            int sum = curA.val + curB.val + carry;
            // 本位结果
            current = sum % 10;
            // 进位
            carry = sum / 10;
            ListNode newNode = new ListNode(current);
            cur.next = newNode;
            cur = cur.next;
            curA = curA.next;
            curB = curB.next;
        }
        if (curA == null) {
            cur = getLast(carry,curB);
        }
        if (curB == null) {
            cur = getLast(carry,curA);
        }
        return result.next;
    }

    private ListNode getLast(int carry, ListNode cur) {
        return null;
    }


    @Test
    public void c() {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        ListNode b = new ListNode(3);
        b.next = new ListNode(2);
        b.next.next = new ListNode(1);
        ListNode res = plusAB(a, b);
        System.out.println(a.val + " " + a.next.val + " " + a.next.next.val);
        System.out.println(b.val + " " + b.next.val + " " + b.next.next.val);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
