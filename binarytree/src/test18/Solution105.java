package test18;

import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    private Map<Integer, Integer> map;

    // 中左右  左中右
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return traversal(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode traversal(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if (preBegin >= preEnd || inBegin >= inEnd) return null;

        int rootVal = preorder[preBegin];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);

        root.left = traversal(preorder, preBegin + 1, preBegin + 1 + index - inBegin, inorder, inBegin, index);
        root.right = traversal(preorder, preBegin + 1 + index - inBegin, preEnd, inorder, index + 1, inEnd);
        
        return root;
    }
}
