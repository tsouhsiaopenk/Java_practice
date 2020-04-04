package Java4_4;


import java.util.ArrayList;
import java.util.List;


class Solution {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    static List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        result.clear();
        if (root == null) {
            return result;
        }
        // 直接递归不好求，通过 hepler() 方法辅助来求
        hepler(root,0);
        return result;
    }

    private void hepler(TreeNode root, int level) {
        if (level == result.size()){
            result.add(new ArrayList<>());
        }
        // 把当前节点田间到 result 中的合适位置
        result.get(level).add(root.val);
        if (root.left != null){
            hepler(root.left,level+1);
        }
        if (root.right != null){
            hepler(root.right,level+1);
        }
    }
}
