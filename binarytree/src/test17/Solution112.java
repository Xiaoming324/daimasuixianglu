package test17;

public class Solution112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return traversal(root, targetSum - root.val);
    }

    /*
     * 如果需要搜索整棵二叉树且不用处理递归返回值，递归函数就不要返回值。
     * 如果需要搜索整棵二叉树且需要处理递归返回值，递归函数就需要返回值。
     * 如果要搜索其中一条符合条件的路径，那么递归一定需要返回值，因为遇到符合条件的路径了就要及时返回。
     *
     * 不要去累加然后判断是否等于目标和，那么代码比较麻烦，可以用递减，让计数器count初始为目标和，然后每次减去遍历路径节点上的数值。
     * 如果最后count == 0，同时到了叶子节点的话，说明找到了目标和。
     * 如果遍历到了叶子节点，count不为0，就是没找到。
     */
    public boolean traversal(TreeNode root, int count) {
        // 叶子节点
        if (root.left == null && root.right == null) {
            return count == 0;
        }

        if (root.left != null) {
            count -= root.left.val;
            if (traversal(root.left, count)) return true;
            count += root.left.val;
        }

        if (root.right != null) {
            count -= root.right.val;
            if (traversal(root.right, count)) return true;
            count += root.right.val;
        }

        return false;
    }


    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        // 叶子结点
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        if (root.left != null) {
            boolean left = hasPathSum1(root.left, targetSum);
            if (left) {      // 已经找到，提前返回
                return true;
            }
        }
        if (root.right != null) {
            boolean right = hasPathSum1(root.right, targetSum);
            if (right) {     // 已经找到，提前返回
                return true;
            }
        }
        return false;
    }

    // 简洁写法
    public boolean hasPathSum2(TreeNode root, int targetSum) {

        if (root == null) return false; // 为空退出

        // 叶子节点判断是否符合
        if (root.left == null && root.right == null) return root.val == targetSum;

        // 求两侧分支的路径和
        return hasPathSum2(root.left, targetSum - root.val) || hasPathSum2(root.right, targetSum - root.val);
    }
}

