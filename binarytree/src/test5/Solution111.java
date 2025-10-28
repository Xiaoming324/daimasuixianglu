package test5;

import java.util.LinkedList;
import java.util.Queue;

public class Solution111 {
    public int minDepth(TreeNode root) {
        int minDepth = 0;
        if (root == null) return minDepth;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            minDepth++;
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                //如果当前节点的左右孩子都为空，直接返回最小深度
                if (poll.left == null && poll.right == null) return minDepth;
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }

        return minDepth;
    }
}
