package Java3_1;

/**
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution2 {
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;

        // 循环遍历链表
        ListNode cur = pHead;
        while(cur != null){
            // 判断cur是否是重复元素
            if (cur.next != null && cur.val == cur.next.val){
                // 说明cur指向的元素就是重复元素，接下来需要找到这个重复元素的末尾
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                // while 结束的时候 cur 指向的是 重复元素的末尾元素
                // 再走一步就意味着 跳过重复元素
                cur = cur.next;
            }else{
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
