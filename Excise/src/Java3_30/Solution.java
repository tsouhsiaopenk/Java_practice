package Java3_30;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    // 后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return null;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    // 先序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    // 根节点的值相等 并且 p.left == q.left && p.right == q.right
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // （1）两个都是空树
        // （2）p空q非空
        // （3）p非空q空
        // （4）pq都不为空
        if (p == null && q == null) {
            return true;
        }
//        if ((p == null && q != null)||(p != null && q == null)){
//            return false;
//        } // 有些麻烦用下面的语句代替
        if (p == null || q == null) {
            // 同时为空已经在上边判定过了，进入的是一个为空，一个非空
            return false;
        }
        // 下面的逻辑进行非空的情况
        // 先判断根节点是否相同
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        boolean ret = false;
        if (s.val == t.val) {
            ret = isSameTree(s, t);
        }
        return ret || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            // 叶子节点
            return 1;
        }
        //return 1 + (maxDepth(root.left) > maxDepth(root.right)
        //          ? maxDepth(root.left) : maxDepth(root.right));
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }

    // 判断一棵二叉树是否平衡
    // 空树，或者没有子树 ： 平衡
    // 针对当前节点，求左右字数的高度，看差值是否大于1
    // 递归判断该树的左右子树是否平衡
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            // 空树认为是平衡的
            return true;
        }
        if (root.left == null && root.right == null) {
            // 只有根节点（没有子树），认为是平衡的
            return true;
        }

        // 其他情况下，判断是否平衡
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 对称二叉树
    public boolean isSymmetric(TreeNode root) {
        // 树是否对称？
        // 看左子树和右子树是否为镜像关系
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            // 一个为空，一个非空
            return false;
        }
        if (t1.val != t2.val) {
            // 两个树的根节点值不同，肯定不是镜像关系
            return false;
        }
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    // 层序遍历
    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
    }
}
