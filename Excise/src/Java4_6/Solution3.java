package Java4_6;

import java.util.Stack;

public class Solution3 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode build() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        c.right = f;
        return a;
    }
    public static void preOrderByLoop(TreeNode root){
        // 借助栈来辅助完成遍历
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            // 访问这个元素
            System.out.print(top.val + " ");
            if (top.right != null){
                stack.push(top.right);
            }
            if (top.left != null){
                stack.push(top.left);
            }
        }
    }

    public static void inOrderByLoop(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(true){
            // 1.循环往左找，把遇到的节点都入栈
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            // 2.如果当前栈为空，说明所有元素已经遍历完了
            if (stack.isEmpty()){
                break;
            }
            // 3.取栈顶元素进行访问
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            // 4.从当前节点的右子树再出发继续刚才的过程
            cur = top.right;
        }
    }
    public static void postOrderByLoop(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // prev 记录了当前已经访问过的节点中的最后一个
        TreeNode prev = root;
        while (true){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()){
                break;
            }
            // 拿出栈顶元素的值，判断是否能够访问
            TreeNode top = stack.peek();
            if (top.right == null || prev == top.right){
                System.out.print(top.val + " ");
                stack.pop();
                prev = top;
            }else{
                cur = top.right;
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = build();
        System.out.println("前序遍历：");
        preOrderByLoop(root);
        System.out.println();
        System.out.println("中序遍历：");
        inOrderByLoop(root);
        System.out.println();
        System.out.println("后序遍历：");
        postOrderByLoop(root);
     }
}
