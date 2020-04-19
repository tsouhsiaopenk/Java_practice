package Java4_19;

public class BinarySearchTree {
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node root = null;

    public boolean insert(int val) {
        if (root == null) {
            root = new Node(val);
            return true;
        }
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else {
                // 重复了
                return false;
            }
        }
        if (val < parent.val) {
            parent.left = new Node(val);
        } else {
            parent.right = new Node(val);
        }
        return true;
    }

    // 中序遍历
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        // 7 3 8 2 9 4 11
        bst.insert(7);
        bst.insert(3);
        bst.insert(8);
        bst.insert(2);
        bst.insert(9);
        bst.insert(4);
        bst.insert(11);
        bst.inOrder(bst.root);
    }
}
