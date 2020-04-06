package Java4_6;


class Solution1 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    /*
        输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
        要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        /*
            基于递归的方式来完成双向链表构建
            为了保证有序，这里使用中序遍历（二叉搜索树的中序遍历是有序的）
         */
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree == null) {
            // 当前节点没有子树 ——> 该双向链表没有前驱和后继节点
            return pRootOfTree;
        }
        // 最终的双向链表 ： 左子树 + 根节点 + 右子树
        // 左子树对应链表末尾与根节点连接，右子树头部再于根节点相连

        // 1.先递归处理左子树
        TreeNode left = Convert(pRootOfTree.left);
        // 2.需要找到左子树对应链表的尾节点
        TreeNode leftTail = left;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        // 3.把左子树的尾节点和根节点连接起来
        if (left != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        // 4.递归处理右子树
        TreeNode right = Convert(pRootOfTree.right);
        // 5.把当前根节点和右子树连接起来
        if (right != null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        // 6.返回新链表的头节点
        // 如果 left = null,链表的头节点就是 pRoootOfTree
        // 如果 left != null,链表的头节点就是left
        return left == null ? pRootOfTree : left;
    }
}
