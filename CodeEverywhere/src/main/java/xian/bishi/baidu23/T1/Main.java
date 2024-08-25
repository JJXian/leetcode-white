package xian.bishi.baidu23.T1;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        int maxDepth = 0;
        int currentDepth = 0;

        while (in.hasNext()) { // 处理多行输入
            String s = in.next();

            if (s.equals("for")) {
                // 遇到 for 时，进入一个新的循环块
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
                stack.push("for");
            } else if (s.equals("{")) {
                // 遇到左括号，将其推入栈中
                stack.push("{");
            } else if (s.equals("}")) {
                // 遇到右括号，判断是否结束一个 for 循环块
                if (!stack.isEmpty() && stack.peek().equals("{")) {
                    stack.pop(); // 弹出一个左括号
                }
                if (!stack.isEmpty() && stack.peek().equals("for")) {
                    stack.pop(); // 弹出一个 for 块
                    currentDepth--; // 结束当前的嵌套
                }
            }
        }

        System.out.println(maxDepth);
    }
}