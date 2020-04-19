package Java4_16;

/*
    二叉搜索数的实现：
    1.插入
    2.查找
    3.删除
 */
public class BinarySearchTree {
    static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    public Node root = null;

    // 查找(查找 key 是否在树中，存在返回对应的 Node.若没有，返回null)
    public Node find(int key) {
        Node cur = root;
        while (cur != null) {
            if (key < cur.key) {
                // 去左子树中找
                cur = cur.left;
            } else if (key > cur.key) {
                // 去右子树中找
                cur = cur.right;
            } else {
                // 找到了
                return cur;
            }
        }
        return null;
    }

    /*
        查找：
            二叉搜索树中没有重复元素，如果重复就返回false
            插入成功返回true
     */
    public boolean insert(int key) {
        if (root == null) {
            root = new Node(key);
            return true;
        }
        // 先找到合适位置，再去插入元素
        Node cur = root;
        Node parent = null; // cur 的 parent 结点
        while (cur != null) {
            if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                // 重复
                return false;
            }
        }
        // 循环结束时候，cur == null
        // 插入元素放在 cur 位置，cur 是 parent 的左子树还是右子树不确定
        // 就需要比较
        if (key < parent.key) {
            parent.left = new Node(key);
        } else {
            parent.right = new Node(key);
        }
        return true;
    }

    /*
        删除元素：
            删除成功返回 true，失败返回 false
            key 在树中存在就删除成功，不在的话，删除失败
     */
    public boolean remove(int key) {
        // 先找到待删除结点，再删除
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                // 找到了待删除元素
                removeNode(parent, cur);
                return true;
            }
        }
        return false;
    }

    private void removeNode(Node parent, Node cur) {
        if (cur.left == null) {
            // 1.待删除元素所在结点没有左子树
            if (cur == root){
                // 1.1 待删除元素为 root
                root = cur.right;
            }else if (cur == parent.left){
                // 1.2 cur 是 parent 的左子树
                parent.left = cur.right;
            }else if (cur == parent.right){
                // 1.3 cur 是 parent 的右子树
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            // 2.待删除元素所在结点没有右子树
            if (cur == root){
                // 2.1 待删除元素为root
                cur = cur.left;
            }if (cur == parent.left){
                parent.left = cur.left;
            }if (cur == parent.right){
                parent.right = cur.left;
            }
        }else {
            // 3.当前待删除元素由两个子树
            // 找到右子树中最小值，放在待删除元素处，使树依旧保持结构
            Node goatParent = cur;
            Node scapeGoat = cur.right;
            // 在右子树中找最小值
            while (scapeGoat.left != null){
                goatParent = scapeGoat;
                scapeGoat = scapeGoat.left;
            }
            // 把刚才的替罪羊的值赋值给待删除结点
            cur.key = scapeGoat.key;
            // 删除替罪羊结点（替罪羊结点一定没有左子树）
            if (scapeGoat == goatParent.left){
                goatParent.left = scapeGoat.right;
            }else{
                goatParent.right = scapeGoat.right;
            }
        }
    }
    public void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.key);
        inOrder(root.right);
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        // 7 3 8 2 9 4 11

        // 2 3 4 7 8 9 11

        // 11 2 9 3 8 4 7
        bst.insert(11);
        bst.insert(2);
        bst.insert(9);
        bst.insert(3);
        bst.insert(8);
        bst.insert(4);
        bst.insert(7);
        bst.inOrder(bst.root);
    }
}
