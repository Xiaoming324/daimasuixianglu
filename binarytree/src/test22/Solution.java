package test22;

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        TreeNode res = null;
        if (val < root.val) {
            res = searchBST(root.left, val);
        }
        if (val > root.val) {
            res = searchBST(root.right, val);
        }

        return res;
    }

    //对于二叉搜索树，不需要回溯的过程，因为节点的有序性就帮我们确定了搜索的方向
    public TreeNode searchBST1(TreeNode root, int val) {
        while (root != null) {
            if (val < root.val) {
                root = root.left;
            } else if (val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
