package Java4_2;

import java.util.LinkedList;
import java.util.Queue;

public class InterViewTree {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /*
        整体思路是：
            通过层序遍历来找反例，如果遍历结束也没有找到反例，就认为是完全二叉树。
                衡量一个二叉树：一般要求每个根节点都有两个子树，
                    如果遇到结点只有右子树，就说明不是完全二叉树
                    如果有左子树没有右子树——>说明从队列中出来的这个结点后面的结点都没有子节点，
                                           如果具有子节点，就说明不是完全二叉树
                    如果左右子树都没有——>同上，说明完全二叉树的有右边没有子节点了。
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 搞一个标志位
        boolean isSecondStep = false;
        // 针对这个树进行层序了、遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // 针对当前结点进行访问，判断是否符合要求
            if (!isSecondStep) {
                // 第一阶段
                if (cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left == null && cur.right != null) {
                    // 当前第一种某个结点只有右子树，没有左子树，一定不是完全二叉树
                    return false;
                } else if (cur.left != null && cur.right == null) {
                    // 切换到第二阶段
                    isSecondStep = true;
                    queue.offer(cur.left);
                }else {
                    isSecondStep = true;
                }
            } else {
                // 第二阶段
                // 要求第二阶段中任何一个结点都没有子树
                // 只要找到某个结点带子树，就说明找到了反例
                if (cur.left != null || cur.right != null){
                    return false;
                }
            }
        }
        // 如果整个树都遍历完了，也没有找到反例，最终就return true,认为是完全二叉树
        return true;
    }
}
