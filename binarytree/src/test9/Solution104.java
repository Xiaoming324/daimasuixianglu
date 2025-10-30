package test9;

import java.util.LinkedList;
import java.util.Queue;

public class Solution104 {

    // 二叉树节点的深度：指从根节点到该节点的最长简单路径边的条数或者节点数（取决于深度从0开始还是从1开始）
    // 二叉树节点的高度：指从该节点到叶子节点的最长简单路径边的条数或者节点前序求的就是深度，使用后序求的是高度数（取决于高度从0开始还是从1开始）
    // 根节点的高度就是二叉树的最大深度!!!!!!
    // 前序求的就是深度，使用后序求的是高度
    // 递归法 (后序遍历)
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    public int maxDepth1(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return depth;
    }
}
