package Java4_4;


public class Solution1 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        findNode(root, p, q);
        return lca;
    }

    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        // 递归按照后续遍历的方式来查找
        // 对于后续遍历查找来说，目标值会出现在三个位置：出现在左子树中，出现在右子树中，出现在根节点中。
        // 如果在左子树中找到 p 或者 q 返回的是真值
        int left = findNode(root.left, p, q) ? 1 : 0;
        // 如果在右子树中找到 p 或者 q 返回的是真值
        int right = findNode(root.right, p, q) ? 1 : 0;
        // 当前节点为 p 或者 q 就会返回 1
        int mid = (root == p || root == q) ? 1 : 0;
        // 找到最近公共祖先的条件：
        //                      1，左子树 + “根节点”
        //                      2，“根节点” + 右子树
        //                      3, 左子树 + 右子树
        if (left + right + mid == 2) {
            lca = root;
        }
        // 若在 左子树 ，右子树 ， 或者该节点中找到一个的话就返回真值
        return (left + right + mid) > 0;
    }
}
