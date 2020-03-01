package Java3_1;


public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给定一个链表，判断链表中是否有环。
     * <p>
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * <p>
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        // 使用快慢指针的方法
        // 定义两个 变量 fast 和 slow
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * <p>
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。
     * <p>
     * 说明：不允许修改给定的链表。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode detectCycle(ListNode head) {
        // 使用快慢指针，找到快慢指针的交点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            while(fast == slow){
                // 链表带环
                break;
            }
        }
        if (fast == null || fast.next == null){
            return null;
        }
        // 带环的情况，设定两个引用，分别从链表头部和fast，slow的交点出发，按照相同的速度同步向后走
        ListNode cur1 = head;
        ListNode cur2 = slow;
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        // 这个位置就是环的入口
        return cur1;
    }
}
