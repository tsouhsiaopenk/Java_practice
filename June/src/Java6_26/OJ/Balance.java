package Java6_26.OJ;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

/**
 * 给定一棵二叉树，判断是否为平衡二叉树。
 * 平衡二叉树的左右子树
 */
public class Balance {

    public boolean isBalance(TreeNode root) {
        // 1.用层序遍历将所有的结点遍历出来，放在队列中
        Queue<TreeNode> queue = getQueue(root);
        // 2.从队列中取出每一个结点进行判断，该子树的左子树和右子树是否平衡
        while (!queue.isEmpty()){
            TreeNode t = queue.poll();
            // 求左子树高度
            int leftHeight = getTreeHeight(t.left);
            // 求右子树的告诉
            int rightHeight = getTreeHeight(t.right);
            // 判断条件是否成立
            if (Math.abs(leftHeight - rightHeight) > 2){
                return false;
            }
        }
        return true;
    }
    // 层序遍历
    private Queue<TreeNode> getQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> helper = new LinkedList<>();
        helper.add(root);
        // 将 helper 中的元素全部添加到queue中
        while (!helper.isEmpty()){
            TreeNode head = helper.poll();
            if (head.left != null){
                helper.add(head.left);
            }
            if (head.right != null){
                helper.add(head.right);
            }
            queue.add(head);
        }
        return queue;
    }

    // 求出一棵二叉树的最大高度
    private int getTreeHeight(TreeNode root) {
        // 如果这个结点为null，返回高度1
        if (root == null){
            return 0;
        }
        // 左子树高度
        int left = getTreeHeight(root.left) + 1;
        // 右子树的高度
        int right = getTreeHeight(root.right) + 1;
        // 返回其中的最大值，即是
        return Math.max(left,right);
    }
}
