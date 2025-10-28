package test5;

import java.util.LinkedList;
import java.util.Queue;

public class Solution104 {

    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if (root == null) return maxDepth;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
        return maxDepth;
    }
}
