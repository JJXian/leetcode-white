package bishi.xgd.T1;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')' && !stack.isEmpty()) {
                res += 2;
                stack.pop();
            }
        }
        System.out.println(res);
    }
}
