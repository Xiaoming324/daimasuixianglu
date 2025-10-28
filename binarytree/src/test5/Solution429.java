package test5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution429 {
    public static void main(String[] args) {
        // 创建测试N叉树
        //           1
        //      /    |    \
        //     3     2     4
        //    / \
        //   5   6

        // 构建节点
        Node root = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        // 构建子节点关系
        List<Node> childrenOfRoot = new ArrayList<>();
        childrenOfRoot.add(node3);
        childrenOfRoot.add(node2);
        childrenOfRoot.add(node4);
        root.children = childrenOfRoot;

        List<Node> childrenOf3 = new ArrayList<>();
        childrenOf3.add(node5);
        childrenOf3.add(node6);
        node3.children = childrenOf3;

        // 调用层序遍历方法
        List<List<Integer>> result = levelOrder(root);

        // 输出结果
        System.out.println("N叉树层序遍历结果:");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("第" + (i + 1) + "层: " + result.get(i));
        }
        // 预期输出:
        // 第1层: [1]
        // 第2层: [3, 2, 4]
        // 第3层: [5, 6]
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                Node poll = queue.poll();
                list.add(poll.val);

                List<Node> children = poll.children;
                if (children != null && children.size() != 0) {
                    for (Node child : children) {
                        if (child != null) queue.offer(child);
                    }
                }
            }
            res.add(list);
        }

        return res;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
