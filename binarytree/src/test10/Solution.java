package test10;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // 最小深度是从根节点到最近叶子节点的最短路径上的节点数量
    // 说明: 叶子节点是指没有子节点的节点
    // 叶子节点（leaf node）：指的是一个非空节点，并且它的左子节点和右子节点都为空。
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);

        if (root.left == null && root.right != null) return 1 + rightHeight;
        if (root.left != null && root.right == null) return 1 + leftHeight;
        // 左右结点都不为null
        return 1 + Math.min(leftHeight, rightHeight);
    }

    public int minDepth1(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                // 是叶子结点，直接返回depth，因为从上往下遍历，所以该值就是最小值
                // 只有当左右孩子都为空的时候，才说明遍历到最低点了。如果其中一个孩子不为空则不是最低点
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return depth;
    }
}
