package com.xian.Z3队列or栈.JZ9用两个栈实现队列;

import java.util.Stack;

/**
 * @Author: jjxian
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
//        入栈1
        stack1.push(node);
    }

    public int pop() {
//      如果栈2为空 将栈1的出栈的栈2
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                int temp = stack1.pop();
                stack2.push(temp);
            }
        }


//        栈2 不为空 直接出栈
        return stack2.pop();

    }
}
