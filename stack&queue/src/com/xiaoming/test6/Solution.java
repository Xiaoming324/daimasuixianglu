package com.xiaoming.test6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (String token : tokens) {
            if (token == "+" || token == "-" || token == "*" || token == "/") {
                int num1 = deque.pop();
                int num2 = deque.pop();
                if (token == "+") deque.push(num1 + num2);
                if (token == "-") deque.push(num2 - num1);
                if (token == "*") deque.push(num1 * num2);
                if (token == "/") deque.push(num2 / num1);
            } else {
                deque.push(Integer.valueOf(token));
            }
        }
        return deque.pop();
    }

    public static int evalRPN1(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        for (String s : tokens) {
            if ("+".equals(s)) {        // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                stack.push(stack.pop() + stack.pop());      // 注意 - 和/ 需要特殊处理
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
