package test8;

public class Solution572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 空树是任何树的子树
        if (subRoot == null) return true;
        // 非空子树不可能是空树的子树
        if (root == null) return false;
        // 在当前节点比较 或 在左子树中找 或 在右子树中找
        return compare(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;

        boolean outside = compare(left.left, right.left);
        boolean inside = compare(left.right, right.right);
        return outside && inside;
    }
}
