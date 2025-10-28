package test5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution199 {
    public static void main(String[] args) {
        // 创建测试二叉树
        //       1
        //      / \
        //     2   3
        //      \   \
        //       5   4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        // 调用方法获取右视图
        List<Integer> result = rightSideView(root);

        // 输出结果
        System.out.println("二叉树的右视图: " + result); // 预期输出: [1, 3, 4]
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                TreeNode node = queue.poll();
                // 当size变为0时，表示这是当前层的最后一个节点
                if (size == 0) result.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }
}
