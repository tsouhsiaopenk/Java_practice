package Java6_25.OJ;

public class Test {
    public ListNode plusAB(ListNode a, ListNode b) {
        // 链表转字符串
        String s1 = getString(a);
        String s2 = getString(b);
        // 字符串转换为整数
        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        // 进行整数计算
        int sum = i1 + i2;
        // 转换为字符串
        String s = String.valueOf(sum);
        // 字符串转化为链表
        ListNode res = getListNode(s);
        return res;
    }

    private ListNode getListNode(String s) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        StringBuilder sb = new StringBuilder(s);
        String rs = sb.reverse().toString();
        for (int i = 0; i < rs.length(); i++) {
            cur.next = new ListNode(rs.charAt(i)-'0');
            cur = cur.next;
        }
        return res.next;
    }

    private String getString(ListNode a) {
        StringBuilder sb = new StringBuilder();
        for (ListNode cur = a; cur != null; cur = cur.next) {
            sb.append(cur.val);
        }
        return sb.reverse().toString();
    }

    @org.junit.Test
    public void Test() {
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
