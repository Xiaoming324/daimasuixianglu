package test31;

public class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // root在[low,high]范围内
        // 将下一层处理完左子树的结果赋给root->left，处理完右子树的结果赋给root->right
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
