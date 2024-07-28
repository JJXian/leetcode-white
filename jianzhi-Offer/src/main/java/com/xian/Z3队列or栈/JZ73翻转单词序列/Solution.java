package com.xian.Z3队列or栈.JZ73翻转单词序列;

import java.util.Stack;

/**
 * @Author: jjxian
 */
public class Solution {

    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0){
            return str;
        }

        String[] strings = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strings.length-1;i>=0;i--){
            sb.append(strings[i]);
            if(i != 0){
                sb.append(' ');
            }
        }
        return sb.toString();
    }


    /**
     * 方法1
     */
//    public String ReverseSentence(String str) {
//        StringBuilder sb = new StringBuilder();
//        Stack<String> stack = new Stack<>();
//        for(int i =0 ;i<str.length();i++){
//            char c = str.charAt(i);
//            if (c != ' ') {
//                sb.append(c);
//            } else {
//                // 添加单词到栈并清空sb
//                stack.push(sb.toString());
//                sb.setLength(0); // 清空sb
//            }
//        }
//        // 添加最后一个单词到栈
//        if (sb.length() > 0) {
//            stack.push(sb.toString());
//        }
//        sb.setLength(0); // 清空sb以重新使用
//        // 从栈中弹出单词并构建新的句子
//        while (!stack.isEmpty()) {
//            sb.append(stack.pop());
//            if (!stack.isEmpty()) {
//                sb.append(' ');
//            }
//        }
//        return sb.toString();
//    }
}
