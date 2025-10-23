package test2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }


    public void preorder(TreeNode current, List<Integer> result) {
        if (current == null) return;
        //前序遍历 中左右
        result.add(current.val);
        preorder(current.left, result);
        preorder(current.right, result);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }


    public void inorder(TreeNode current, List<Integer> result) {
        if (current == null) return;
        //中序遍历 左中右
        inorder(current.left, result);
        result.add(current.val);
        inorder(current.right, result);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }


    public void postorder(TreeNode current, List<Integer> result) {
        if (current == null) return;
        //后序遍历 左右中
        postorder(current.left, result);
        postorder(current.right, result);
        result.add(current.val);
    }
}
