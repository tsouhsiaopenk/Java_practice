package Java4_4;

import java.util.Scanner;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}

public class Main {
    // 静态变量记录当前位置
    public static int index = 0;

    // 根据传入的字符串建立一棵二叉树
    public TreeNode build(String line) {
        // index是一个专门的记录变量，
        // 为了在后面的递归创建过程中时刻能知道当前访问到line中的那个元素了
        // 通过下面的方法辅助完成递归
        index = 0;

        return creatTreePreOrder(line);
    }

    private TreeNode creatTreePreOrder(String line) {
        // 获取当前处理那个结点
        char cur = line.charAt(index);
        if (cur == '#') {
            return null;
        }
        // 当前字符不是 # 号 就创建一个结点
        TreeNode root = new TreeNode(cur);
        // 下一个结点
        index++;
        root.left = creatTreePreOrder(line);
        index++;
        root.right = creatTreePreOrder(line);
        return root;
    }

    // 中序遍历
    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        // 注意格式，每个字符后面都有一个空格
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 在线OJ一般有多组输入
        // 用户传入构建二叉树的字符串
        while (scanner.hasNext()) {
            // line 就对应一组输入数据
            String line = scanner.next();
            // 调用程序构建二叉树
            Main interviewTree = new Main();
            TreeNode root = interviewTree.build(line);
            // 进行中序遍历
            interviewTree.inorderTraversal(root);
            // 注意格式的问题
            System.out.println();
        }
    }
}
