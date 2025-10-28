package test5;

import java.util.*;

public class Solution107 {
    public static void main(String[] args) {
        // 构建测试二叉树:
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

        Solution107 solution = new Solution107();
        List<List<Integer>> result = solution.levelOrderBottom(root);

        // 预期输出: [[15,7],[9,20],[3]]
        System.out.println("Bottom-up level order traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }


    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(result);
        return result;
    }

    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        // 利用链表可以进行 O(1) 头部插入, 这样最后答案不需要再反转
        LinkedList<List<Integer>> ans = new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                temp.add(node.val);

                if (node.left != null) q.offer(node.left);

                if (node.right != null) q.offer(node.right);
            }

            // 新遍历到的层插到头部, 这样就满足按照层次反序的要求
            // Linkedlist addFirst 在列表开头插入元素
            ans.addFirst(temp);
        }

        return ans;
    }

}
