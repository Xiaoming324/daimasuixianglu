package test32;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    // []左闭右闭
    // 如果根据数组构造一棵二叉树，本质就是寻找分割点，分割点作为当前节点，然后递归左区间和右区间。
    public TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) return null;
        //相当于是如果数组长度为偶数，中间位置有两个元素，取靠左边的。
        int mid = left + ((right - left) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversal(nums, left, mid - 1);
        root.right = traversal(nums, mid + 1, right);

        return root;
    }

    // [)左闭右开
    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }
}
