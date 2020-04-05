package Java4_5;

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }
        // 1. 先递归处理左子树.
        // left 就是左子树这个链表的根节点
        TreeNode left = Convert(pRootOfTree.left);
        // 2. 需要找到左子树链表的尾节点
        TreeNode leftTail = left;
        // right 相当于链表的 next
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        // 循环结束之后, leftTail 就指向了左侧链表的尾部
        // 3. 把左子树和当前节点连在一起
        if (left != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        // 4. 递归转换右子树, 把右子树也变成双向链表
        TreeNode right = Convert(pRootOfTree.right);
        // 5. 把当前节点和右子树连在一起
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        // 6. 最终返回 新的链表的头结点
        // 如果 left 为 null, 链表的头结点就是 pRootOfTree
        // 如果 left 非 null, 头结点就是 left
        return left == null ? pRootOfTree : left;
    }
}
