package test13;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // 构建测试二叉树:
        //       1
        //      / \
        //     2   3
        //      \
        //       5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        Solution solution = new Solution();
        List<String> paths = solution.binaryTreePaths(root);

        System.out.println("二叉树的所有路径:");
        for (String path : paths) {
            System.out.println(path);
        }
        // 预期输出:
        // 1->2->5
        // 1->3
    }

    // 递归法
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();// 存最终的结果
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();// 作为结果中的路径
        traversal(root, paths, res);
        return res;
    }

    // 前序遍历，这样才方便让父节点指向孩子节点，找到对应的路径
    // paths记录单挑路径 res记录最后结果
    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        // 中写在这里是因为终止条件到叶子节点就结束了，如果写在终止条件下面，叶子节点的值不会放进paths里
        paths.add(root.val); // 前序遍历，中
        // 遇到叶子节点
        if (root.left == null && root.right == null) {
            //输出
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1)); //记录最后一个节点
            res.add(sb.toString()); //收集一个路径
        }
        // 递归和回溯是同时进行，所以要放在同一个花括号里
        if (root.left != null) {
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }

        if (root.right != null) {
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }
    }
}
