package test33;

public class Solution2 {
    private int pre;

    public TreeNode convertBST(TreeNode root) {
        pre = 0;
        traversal(root);
        return root;
    }

    public void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.right);
        root.val += pre;
        pre = root.val;
        traversal(root.left);
    }
}
