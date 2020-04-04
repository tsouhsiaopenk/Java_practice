package Java4_4;

public class Solution2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    // 使用 sb 表示最终得到的字符串结果
    // 递归过程中得到的局部结构都往 sb 中 追加即可
    private StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t == null){
            // 此处返回的是一个空字符串，而不是 null
            return "";
        }
        // 借助 helper 方法递归遍历
        helper(t);
        // 递归得到的字符串最前面和最后面的括号是多余的
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private void helper(TreeNode t) {
        if (t == null){
            return;
        }
        // 访问根节点，此处的访问操作追加字符串到sb中即可
        sb.append("(");
        sb.append(t.val);
        helper(t.left);
        if (t.left == null && t.right != null){
            // 左子树为空，右子树非空
            // 一定 要加上一组()来占位
            sb.append("()");
        }
        helper(t.right);
        sb.append(")");
    }
}
