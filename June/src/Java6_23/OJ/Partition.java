package Java6_23.OJ;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // 此处带有傀儡结点
        ListNode smallPart = new ListNode(-1);
        ListNode bigPart = new ListNode(-1);
        // 用来标记链表头所在位置
        ListNode small = smallPart;
        ListNode big = bigPart;
        // write code here
        for (ListNode cur = pHead; cur != null; cur = cur.next) {
            ListNode newNode = new ListNode(cur.val);
            if (cur.val < x){
                smallPart.next = newNode;
                smallPart = smallPart.next;
            }else {
                bigPart.next = newNode;
                bigPart = bigPart.next;
            }
        }
        smallPart.next = big.next;
        return small.next;
    }
}
