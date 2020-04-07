package Java4_6;

import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public boolean isCompleteTree(TreeNode root) {
        if (root == null){
            return true;
        }
        // 借助队列来实现，如果队列中有出栈节点没有右子树或者左右子树的话，
        // 后面的所有节点就都没有子树。
        // 我们在这里建立一个状态变量,来记录对对栈中元素区别对待的实际
        // 我们在队列有出栈的某个节点没有左子树或者左右子树的话（若没有左子树，有右子树的一定不是完全二叉树）
        // 就进行状态改变
        boolean state = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            // 访问队首元素
            TreeNode teamLeader = queue.poll();
            // state 的值改变时，状态就发生变化，进入第二状态，当前第一状态
            if (state == false){
                if (teamLeader.left != null && teamLeader.right != null){
                    queue.offer(teamLeader.left);
                    queue.offer(teamLeader.right);
                }
                if (teamLeader.left != null && teamLeader.right == null){
                    queue.offer(teamLeader.left);
                    state = true;
                }
                if (teamLeader.left == null && teamLeader.right != null) {
                    // 此时一定不是完全二叉树
                    return false;
                }
                if (teamLeader.left == null && teamLeader.right == null){
                    state = true;
                }
            }else{
                if (teamLeader.left != null || teamLeader.right != null){
                    return false;
                }
            }
        }
        return true;
    }
}
