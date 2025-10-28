package test6;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 想要翻转二叉树，其实就只要把每一个节点的左右孩子翻转一下，就可以达到整体翻转的效果
 * 前后序遍历都可以
 * 中序不行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），再右孩子交换孩子（此时其实是对原来的左孩子做交换）, 也就是说原来的右孩子根本没有处理
 */

public class Solution {

    // 前序遍历
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    // 层序遍历
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode poll = queue.poll();

                TreeNode temp = poll.left;
                poll.left = poll.right;
                poll.right = temp;

                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
        return root;
    }
}
