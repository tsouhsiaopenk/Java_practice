package Java5_3;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
/*
    输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

    思路：我们知道先序遍历的第一个元素是根节点，这样我们就可以拿着该结点找到其在中序遍历结果中的位置，
         把inorder数组分成左右子树两部分,使用递归不断划分，直到最后左右子树都无法划分
 */
public class Solution {
    private int index = 0; // 当前访问到先序遍历中的第几个元素
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // int index = 0;
        return buildTreeHelper(preorder,inorder,0,inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
        if (left >= right){
            return null;
        }
        if (index > preorder.length){
            return null;
        }
        // 构造根节点
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        // 根据该结点在中序遍历的结果中的位置，把inorder数组分成左右子树两部分
        int pos = findPos(inorder,left,right,root.val);
        root.left = buildTreeHelper(preorder, inorder, left, pos);
        root.right = buildTreeHelper(preorder, inorder, pos+1, right);
        return root;
    }

    private int findPos(int[] inorder, int left, int right, int toFind) {
        // inorder 是中序遍历的结果数组
        // left 是中序遍历的开始位置
        // right 是中序遍历的结束位置
        // toFind 是前序遍历的第一个结点，即根节点
        for (int i = left; i < right; i++) {
            if (inorder[i] == toFind){
                return i;
            }
        }
        return -1;
    }
}
