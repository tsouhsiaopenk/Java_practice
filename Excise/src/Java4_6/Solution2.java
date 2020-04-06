package Java4_6;

public class Solution2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    private int index; // 当前访问到先序遍历中的第几个元素
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return buildTreeHelper(preorder,inorder,0,inorder.length);
    }

     /*
            传入参数的意义：
                preorder 前序遍历结果数组
                inorder 中序遍历结果数组
                left 中序遍历时的开始位置
                right 中序遍历时的结束位置

     */
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
        if (left >= right){
            // 中序遍历结果为空，这个树就是空树
            return null;
        }
        if (index > preorder.length){
            // 遍历元素结束
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        // 根据该节点在中序遍历结果中 的位置，把inorder数组分成左右子树两部分
        int pos = findPos(inorder,left,right,root.val);
        root.left = buildTreeHelper(preorder, inorder, left, pos);
        root.right = buildTreeHelper(preorder, inorder, pos + 1, right);
        return root;
    }

    private int findPos(int[] inorder, int left, int right, int toFind) {
        // inorder 是中序遍历的的结果数组
        // left 是 中序遍历的开始位置
        // right 是 中序遍历的结束位置
        // toFind 是 前序遍历的第一个节点，即根节点
        for (int i = left; i < right; i++) {
            if (inorder[i] == toFind){
                return i;
            }
        }
        return -1;
    }

}
