package test19;

//构造树一般采用的是前序遍历，因为先构造中间节点，然后递归构造左子树和右子树。
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traversal(nums, 0, nums.length);
    }

    public TreeNode traversal(int[] nums, int begin, int end) {
        if (begin >= end) return null;

        int maxValue = nums[begin];
        int index = begin;
        for (int i = begin + 1; i < end; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);

        root.left = traversal(nums, begin, index);
        root.right = traversal(nums, index + 1, end);

        return root;
    }
}
