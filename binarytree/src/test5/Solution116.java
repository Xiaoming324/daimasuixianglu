package test5;

import java.util.LinkedList;
import java.util.Queue;

public class Solution116 {
    public Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Node current = queue.poll();
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);

            for (int i = 1; i < size; i++) {
                Node next = queue.poll();
                if (next.left != null) queue.offer(next.left);
                if (next.right != null) queue.offer(next.right);
                current.next = next;
                current = next;
            }
        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
