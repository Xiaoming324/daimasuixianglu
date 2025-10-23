package com.xiaoming.test3;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        rePosition();
        return queue.poll();
    }

    public int top() {
        rePosition();
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public void rePosition() {
        int size = queue.size();
        size--;
        while (size-- > 0)
            queue.add(queue.poll());
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */