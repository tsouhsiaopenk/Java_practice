package Java1_23;

import java.util.List;

/**
 * 删除链表中等于给定值 val 的所有节点。 OJ链接
 * 反转一个单链表。 OJ链接
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。OJ链接
 * 输入一个链表，输出该链表中倒数第k个结点。 OJ链接
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。OJ链接
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前 。OJ链接
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 OJ链接
 * 链表的回文结构。OJ链接
 * 输入两个链表，找出它们的第一个公共结点。OJ链接
 * 给定一个链表，判断链表中是否有环。 OJ链接
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null OJ链接
 */
class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListOJ {
    // 删除链表中给定值 val 的所有节点
    public ListNode removeElements(ListNode head, int val) {
        // 若为头节点
        if (head.val==val){
            head = head.next;
        }
        // 删除非头节点，需要找到待删除节点的前一个位置
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                // 删除cur节点
                prev.next = cur.next;
                cur = prev.next;
            } else {
                // prev和cur同时向后移动
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
