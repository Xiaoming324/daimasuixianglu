package test11;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // 完全二叉树 满二叉树的结点数为：2^depth - 1
    // 在完全二叉树中，如果递归向左遍历的深度等于递归向右遍历的深度，那说明就是满二叉树
    // 在完全二叉树中，如果递归向左遍历的深度不等于递归向右遍历的深度，则说明不是满二叉树
    // 这种写法不用遍历所有的节点，如果判断是满二叉树的话，只遍历了左右两边的节点，内部的节点无需遍历
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        TreeNode left = root.left, right = root.right;
        int leftDepth = 0, rightDepth = 0; // 这里初始为0是有目的的，为了下面求指数方便
        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) return (2 << leftDepth - 1); // 注意(2<<1) 相当于2^2 (2*2^1)，所以leftDepth初始为0

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
    }

    // 后序遍历 普通二叉树解法 时间复杂度是O(n)
    public int countNodes1(TreeNode root) {
        if (root == null) return 0;
        int leftCount = countNodes1(root.left);
        int rightCount = countNodes1(root.right);
        return leftCount + rightCount + 1;
    }

    public int countNodes2(TreeNode root) {
        int count = 0;
        if (root == null) return count;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return count;
    }
}
