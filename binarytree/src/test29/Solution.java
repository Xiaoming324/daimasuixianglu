package test29;

public class Solution {
    // 只要遍历二叉搜索树，找到空节点(叶子节点) 插入元素就可以了
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {// 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode newRoot = root;
        TreeNode pre = root;
        while (root != null) {
            pre = root;
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            }
        }
        if (pre.val > val) {
            pre.left = new TreeNode(val);
        } else {
            pre.right = new TreeNode(val);
        }

        return newRoot;
    }
}
