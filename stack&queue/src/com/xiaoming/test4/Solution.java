package com.xiaoming.test4;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        System.out.println(isValid("({{}}()[]}")); // false
        System.out.println(isValid("({{}}()[])")); // true - 正确匹配
        System.out.println(isValid("()")); // true
        System.out.println(isValid("()[]{}")); // true
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                //碰到左括号，就把相应的右括号入栈
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                //如果是右括号判断是否和栈顶元素匹配
                default:
                    if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        //遍历结束，如果栈为空，则括号全部匹配
        return stack.isEmpty();
    }
}