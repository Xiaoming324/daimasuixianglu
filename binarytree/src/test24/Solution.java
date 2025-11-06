package test24;

import java.util.ArrayDeque;

public class Solution {
    private TreeNode pre = null;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return minDiff;
    }

    public void traversal(TreeNode cur) {
        if (cur == null) return;

        traversal(cur.left);

        if (pre != null) minDiff = Math.min(minDiff, cur.val - pre.val);
        pre = cur;

        traversal(cur.right);
    }

    //迭代法
    public int getMinimumDifference1(TreeNode root) {
        if (root == null) return 0;
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        while (root != null || !arrayDeque.isEmpty()) {
            if (root != null) {
                arrayDeque.push(root);
                root = root.left;
            } else {
                root = arrayDeque.pop();
                if (pre != null) minDiff = Math.min(minDiff, root.val - pre.val);
                pre = root;
                root = root.right;
            }
        }
        return minDiff;
    }
}
