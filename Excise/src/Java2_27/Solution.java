package Java2_27;


public class Solution {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode partition(ListNode pHead, int x) {
        // 若链表位空直接返回null
        if (pHead == null){
            return null;
        }
        // 创建两个具有傀儡结点的链表，用来存放数值 x 两边的值
        ListNode smallHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);
        // 创建一个变量
        ListNode cur = pHead;
        ListNode smallCur = smallHead;
        ListNode bigCur = bigHead;
        while(cur != null){
            if (cur.val < x){
                ListNode newNode = new ListNode(cur.val);
                smallCur.next = newNode;
                smallCur = smallCur.next;
                cur = cur.next;
            }else{
                ListNode newNode = new ListNode(cur.val);
                bigCur.next = newNode;
                bigCur = bigCur.next;
                cur = cur.next;
            }
        }
        // 将smallHead 放在左边，bigHead 放在右边
        smallCur.next = bigHead.next;
        return smallHead.next;
    }
}
