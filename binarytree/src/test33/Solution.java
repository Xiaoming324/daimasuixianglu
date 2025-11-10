package test33;

public class Solution {
    private TreeNode pre;

    public TreeNode convertBST(TreeNode root) {
        pre = null;
        traversal(root);
        return root;
    }

    public void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.right);
        if (pre != null) {
            root.val += pre.val;
        }
        pre = root;
        traversal(root.left);
    }

}
