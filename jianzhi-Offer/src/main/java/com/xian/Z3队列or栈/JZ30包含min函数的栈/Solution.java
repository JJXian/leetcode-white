package com.xian.Z3队列or栈.JZ30包含min函数的栈;

import java.util.Stack;

/**
 * @Author: jjxian
 */
public class Solution {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty()){
            minStack.push(node);
        }else if(node<=minStack.peek()){
            minStack.push(node);
        }
    }

    public void pop() {
        int num = stack.pop();
        if(num == minStack.peek()){
            minStack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
