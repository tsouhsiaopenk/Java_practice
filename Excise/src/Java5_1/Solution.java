package Java5_1;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public int[] reversePrint(ListNode head) {
        int length = getSize(head);
        // 定义一个数组
        int[] result = new int[length];
        ListNode cur = head;
        // 将链表中的元素倒序放在数组中
        for (int i = length-1; i >=0 && cur != null; i--) {
            result[i] = cur.val;
            cur = cur.next;
        }
        return result;
    }
    private int getSize(ListNode head){
        ListNode cur = head;
        int size = 0;
        while (cur != null){
            cur = cur.next;
            size ++;
        }
        return size;
    }
}
