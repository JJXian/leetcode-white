package com.xian.Z3队列or栈.JZ31栈的压入弹出序列;

import java.util.Stack;

/**
 * @Author: jjxian
 */
public class Solution {
    public boolean IsPopOrder (int[] pushV, int[] popV) {
        Stack<Integer> stack = new Stack<>();
        //        如果当前元素不等于出栈元素 持续入栈
        int index = 0;
        for(int i =0 ;i< pushV.length;i++){
            stack.push(pushV[i]);
//            匹配出栈元素
            while(!stack.isEmpty() && stack.peek() == popV[index]){
                index++;
                stack.pop();
            }
        }
        return stack.isEmpty();

/**
 * 优化之前
 */
//        for(int i = 0;i<pushV.length;i++){
////            相等 出栈序列下标加一
//            if(pushV[i] == popV[index]){
//                index++;
////                如果栈不为空 尝试出栈
//                while(!stack.isEmpty()){
////                    如果栈顶元素和出栈序列相等 出栈
//                    if(stack.peek() == popV[index]){
//                        index++;
//                        stack.pop();
//                    }else{
//                        break;
//                    }
//                }
//            }else{
//                stack.push(pushV[i]);
//            }
//        }
//
//        while(!stack.isEmpty()){
//            if(stack.pop() != popV[index++]){
//                return false;
//            }
//        }
//        return true;
    }
}
