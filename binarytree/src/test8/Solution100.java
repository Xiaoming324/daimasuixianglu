package test8;

import java.util.Deque;
import java.util.LinkedList;

public class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;

        boolean outside = compare(left.left, right.left);
        boolean inside = compare(left.right, right.right);
        return (outside && inside);
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(p);
        deque.offerLast(q);
        while (!deque.isEmpty()) {
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollLast();
            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;
            deque.offerFirst(left.right);
            deque.offerLast(right.right);
            deque.offerFirst(left.left);
            deque.offerLast(right.left);
        }
        return true;
    }
}
