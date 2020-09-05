package Java8_31;

/**
 * 合并两个排序链表
 */
class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 如果链表为空，直接返回
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(-1);
        ListNode currentNode = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode newNode = new ListNode(l1.val);
                l1 = l1.next;
                currentNode.next = newNode;
            } else {
                ListNode newNode = new ListNode(l2.val);
                l2 = l2.next;
                currentNode.next = newNode;
            }
            currentNode = currentNode.next;
        }
        if (l1 != null) {
            currentNode.next = l1;
        }
        if (l2 != null) {
            currentNode.next = l2;
        }
        return result.next;
    }
}
