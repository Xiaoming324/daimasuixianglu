package test18;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一步：如果数组大小为零的话，说明是空节点了。
 * 第二步：如果不为空，那么取后序数组最后一个元素作为节点元素。(如果数组大小为一，说明是叶子节点)。
 * 第三步：找到后序数组最后一个元素在中序数组的位置，作为切割点
 * 第四步：切割中序数组，切成中序左数组和中序右数组 （顺序别搞反了，一定是先切中序数组）
 * 第五步：切割后序数组，切成后序左数组和后序右数组
 * 第六步：递归处理左区间和右区间
 */
public class Solution106 {

    Map<Integer, Integer> map;  // 方便根据数值查找位置

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        return traversal(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode traversal(int[] inorder, int inorderBegin, int inorderEnd, int[] postorder, int postorderBegin, int postorderEnd) {
        if (postorderBegin == postorderEnd) return null;

        int rootVal = postorder[postorderEnd - 1];
        TreeNode root = new TreeNode(rootVal);

        if (postorderEnd - postorderBegin == 1) return root;

        int index;
        for (index = inorderBegin; index < inorderEnd; index++) {
            if (inorder[index] == rootVal) break;
        }

        // 切割中序数组
        // 左中序区间，左闭右开[leftInorderBegin, leftInorderEnd)
        int leftInorderBegin = inorderBegin;
        int leftInorderEnd = index;
        // 右中序区间，左闭右开[rightInorderBegin, rightInorderEnd)
        int rightInorderBegin = index + 1;
        int rightInorderEnd = inorderEnd;

        // 切割后序数组
        // 左后序区间，左闭右开[leftPostorderBegin, leftPostorderEnd)
        int leftPostorderBegin = postorderBegin;
        int leftPostorderEnd = postorderBegin + (leftInorderEnd - leftInorderBegin); // 终止位置是 需要加上 左中区间的大小size
        // 右后序区间，左闭右开[rightPostorderBegin, rightPostorderEnd)
        int rightPostorderBegin = postorderBegin + (leftInorderEnd - leftInorderBegin);
        int rightPostorderEnd = postorderEnd - 1;

        root.left = traversal(inorder, leftInorderBegin, leftInorderEnd, postorder, leftPostorderBegin, leftPostorderEnd);
        root.right = traversal(inorder, rightInorderBegin, rightInorderEnd, postorder, rightPostorderBegin, rightPostorderEnd);

        return root;
    }

    // 上面的时间复杂度因线性找根是 O(n^2)，用 HashMap 存中序索引可降到 O(n)
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
            map.put(inorder[i], i);
        }

        return findNode1(inorder, 0, inorder.length, postorder, 0, postorder.length);  // 前闭后开
    }

    public TreeNode findNode1(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        // 参数里的范围都是前闭后开
        if (inBegin >= inEnd || postBegin >= postEnd) {  // 不满足左闭右开，说明没有元素，返回空树
            return null;
        }
        int rootIndex = map.get(postorder[postEnd - 1]);  // 找到后序遍历的最后一个元素在中序遍历中的位置
        TreeNode root = new TreeNode(inorder[rootIndex]);  // 构造结点
        int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树个数，用来确定后序数列的个数
        root.left = findNode1(inorder, inBegin, rootIndex,
                postorder, postBegin, postBegin + lenOfLeft);
        root.right = findNode1(inorder, rootIndex + 1, inEnd,
                postorder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }
}
