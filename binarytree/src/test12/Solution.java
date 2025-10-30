package test12;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    // -1 表示已经不是平衡二叉树了，否则返回值是以该节点为根节点树的高度
    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) return -1;

        // 左右子树高度差大于1，return -1表示已经不是平衡树了
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }


    /**
     * 迭代法，效率较低，计算高度时会重复遍历
     * 时间复杂度：O(n^2)
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode inNode = stack.peek();
            // 右结点为null或已经遍历过
            if (inNode.right == null || inNode.right == pre) {
                // 比较左右子树的高度差，输出
                if (Math.abs(getHeight1(inNode.left) - getHeight1(inNode.right)) > 1) {
                    return false;
                }
                stack.pop();
                pre = inNode;
                root = null;// 当前结点下，没有要遍历的结点了
            } else {
                root = inNode.right;// 右结点还没遍历，遍历右结点
            }
        }
        return true;
    }

    /**
     * 层序遍历，求结点的高度
     */
    public int getHeight1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        return depth;
    }

}
