package test3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 递归的实现就是：每一次递归调用都会把函数的局部变量、参数值和返回地址等压入调用栈中
 * 前序遍历的顺序是中左右，先访问的元素是中间节点，要处理的元素也是中间节点，所以刚刚才能写出相对简洁的代码，因为要访问的元素和要处理的元素顺序是一致的，都是中间节点
 * 中序遍历是左中右，先访问的是二叉树顶部的节点，然后一层一层向下访问，直到到达树左面的最底部，再开始处理节点（也就是在把节点的数值放进result数组中），这就造成了处理顺序和访问顺序是不一致的。
 * */
public class Solution {
    // 前序遍历顺序：中-左-右，入栈顺序：中-右-左
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.push(root);
        TreeNode current;
        while (!arrayDeque.isEmpty()) {
            current = arrayDeque.pop();
            result.add(current.val);
            if (current.right != null) arrayDeque.push(current.right);
            if (current.left != null) arrayDeque.push(current.left);
        }
        return result;
    }

    // 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.push(root);
        TreeNode current;
        while (!arrayDeque.isEmpty()) {
            current = arrayDeque.pop();
            result.add(current.val);
            if (current.left != null) arrayDeque.push(current.left);
            if (current.right != null) arrayDeque.push(current.right);
        }
        Collections.reverse(result);
        return result;
    }

    // 中序遍历顺序: 左-中-右 入栈顺序： 左-右
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        TreeNode current = root;
        while (current != null || !arrayDeque.isEmpty()) {
            if (current != null) {
                arrayDeque.push(current);
                current = current.left;
            } else {
                current = arrayDeque.pop();
                result.add(current.val);
                current = current.right;
            }
        }
        return result;
    }
}
