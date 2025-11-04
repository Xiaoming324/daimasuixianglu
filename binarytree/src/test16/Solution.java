package test16;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int result;
    private int maxDepth = Integer.MIN_VALUE;

    //如果使用递归法，如何判断是最后一行呢，其实就是深度最大的叶子节点一定是最后一行。
    public int findBottomLeftValue(TreeNode root) {
        result = root.val;
        traversal(root, 1);
        return result;
    }

    // 因为不对中采取措施 只需保证左在右前面即可
    public void traversal(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                result = root.val;
            }
        }
        if (root.left != null) {
            depth++;
            traversal(root.left, depth);
            depth--;
            // 等价于 traversal(root.left, depth+1);
        }
        if (root.right != null) {
            depth++;
            traversal(root.right, depth);
            depth--;
            // 等价于 traversal(root.right, depth+1);
        }
    }

    public int findBottomLeftValue1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) result = poll.val;
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
        return result;
    }
}
