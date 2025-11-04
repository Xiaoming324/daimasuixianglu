package test17;

import java.util.ArrayList;
import java.util.List;

public class Solution113 {
    private List<List<Integer>> res;
    private List<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        if (root == null) return res;
        path = new ArrayList<>();
        path.add(root.val);
        traversal(root, targetSum - root.val);
        return res;
    }

    public void traversal(TreeNode root, int count) {
        if (root.left == null && root.right == null) {
            //直接将 path 添加到结果集 res 中会导致引用问题
            //由于 path 是一个对象引用，后续对 path 的修改会影响已经添加到 res 中的路径
            //这会导致最终结果中的所有路径都是相同的（都是最后一次遍历的路径状态）
            if (count == 0) res.add(new ArrayList<>(path));
            return;
        }

        if (root.left != null) {
            path.add(root.left.val);
            count -= root.left.val;
            traversal(root.left, count);
            count += root.left.val;
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.right.val);
            count -= root.right.val;
            traversal(root.right, count);
            count += root.right.val;
            path.remove(path.size() - 1);
        }
    }
}
