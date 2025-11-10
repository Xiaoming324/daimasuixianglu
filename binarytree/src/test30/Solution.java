package test30;

public class Solution {
    //二叉搜索树添加节点只需要在叶子上添加就可以的，不涉及到结构的调整，而删除节点操作涉及到结构的调整。

    //第一种情况：没找到删除的节点，遍历到空节点直接返回了
    //找到删除的节点
    //第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
    //第三种情况：删除节点的左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
    //第四种情况：删除节点的右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
    //第五种情况：左右孩子节点都不为空，则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，返回删除节点右孩子为新的根节点。
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null; // 第一种情况：没找到删除的节点，遍历到空节点直接返回了
        if (root.val == key) {
            // 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
            if (root.left == null && root.right == null) {
                return null;
            }
            // 第三种情况：其左孩子为空，右孩子不为空，删除节点，右孩子补位 ，返回右孩子为根节点
            else if (root.left == null && root.right != null) {
                return root.right;
            }
            // 第四种情况：其右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
            else if (root.left != null && root.right == null) {
                return root.left;
            }
            // 第五种情况：左右孩子节点都不为空，则将删除节点的左子树放到删除节点的右子树的最左面节点的左孩子的位置 （移动完之后相当于左为空右不为空的情况）
            // 并返回删除节点右孩子为新的根节点。
            else {
                TreeNode cur = root.right;  // 找右子树最左面的节点
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left; // 把要删除的节点（root）左子树放在cur的左孩子的位置
                return root.right;
            }
        }

        if (key < root.val) root.left = deleteNode(root.left, key);
        if (key > root.val) root.right = deleteNode(root.right, key);

        return root;
    }

    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }
        if (root.val > key) root.left = deleteNode1(root.left, key);
        if (root.val < key) root.right = deleteNode1(root.right, key);
        return root;
    }
}
