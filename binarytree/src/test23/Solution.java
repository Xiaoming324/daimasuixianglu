package test23;

import java.util.ArrayDeque;

public class Solution {
    // 中序遍历二叉搜索树 得到的元素是有序的 单调递增
    private TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }

        if (pre != null && pre.val >= root.val) return false;
        pre = root;// 记录前一个节点

        boolean right = isValidBST(root.right);

        return left && right;
    }

    // 迭代法
    public boolean isValidBST1(TreeNode root) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !deque.isEmpty()) {
            if (cur != null) {
                deque.push(cur);
                cur = cur.left;
            } else {
                cur = deque.pop();
                if (pre != null && pre.val >= cur.val) return false;
                pre = cur;
                cur = cur.right;
            }
        }
        return true;
    }
}
