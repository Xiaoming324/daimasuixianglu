package test5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {

    public static void main(String[] args) {
        // 创建一个测试二叉树:
        //       3
        //      / \
        //     9   20
        //        /  \
        //       15   7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        List<List<Integer>> result = levelOrder(root);

        // 打印结果
        System.out.println("层序遍历结果:");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("第" + (i + 1) + "层: " + result.get(i));
        }

        // 预期输出:
        // 第1层: [3]
        // 第2层: [9, 20]
        // 第3层: [15, 7]
    }


    // 迭代方式--借助队列
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(list);
        }
        return result;
    }
}
