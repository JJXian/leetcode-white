package xian.bishi.bilibili0821.t2;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int res = count(s);
        System.out.println(res);
    }

    public static int count(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return count;
                }
                stack.pop();
                count += 2;
            }
        }
        return count;
    }
}
