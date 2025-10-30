package test9;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution559 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int height = 0;
        if (root.children != null) {
            for (Node child : root.children) {
                height = Math.max(height, maxDepth(child));
            }
        }
        return height + 1; //中节点
    }

    public int maxDepth1(Node root) {
        int depth = 0;
        if (root == null) return depth;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size-- > 0) {
                Node node = queue.poll();
                if (node.children != null) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
        }
        return depth;
    }

    class Node {
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
