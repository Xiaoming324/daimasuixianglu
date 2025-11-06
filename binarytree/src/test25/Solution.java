package test25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    private TreeNode pre;
    private int count;
    private int maxCount;
    private List<Integer> res;

    public int[] findMode(TreeNode root) {
        pre = null;
        count = 0;
        maxCount = 0;
        res = new ArrayList<>();
        traversal(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public void traversal(TreeNode cur) {
        if (cur == null) return;

        traversal(cur.left);
        if (pre == null || pre.val != cur.val) {
            count = 1;
        } else {
            count++;
        }
        if (count == maxCount) {
            res.add(cur.val);
        } else if (count > maxCount) {
            maxCount = count;
            res.clear();
            res.add(cur.val);
        }
        pre = cur;
        
        traversal(cur.right);
    }


    // 普通二叉树
    // 如果不是二叉搜索树，最直观的方法一定是把这个树都遍历了，用map统计频率，把频率排个序，最后取前面高频的元素的集合
    public int[] findMode1(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res.stream().mapToInt(Integer::intValue).toArray();

        traversal1(root, map);

        List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream().sorted(((o1, o2) -> o2.getValue().compareTo(o1.getValue()))).collect(Collectors.toList());

        int maxCount = mapList.get(0).getValue();
        for (Map.Entry<Integer, Integer> entry : mapList) {
            if (entry.getValue().equals(maxCount)) {
                res.add(entry.getKey());
            } else {
                break;
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public void traversal1(TreeNode cur, Map<Integer, Integer> map) {
        if (cur == null) return;
        traversal1(cur.left, map);
        map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
        traversal1(cur.right, map);
    }
}
