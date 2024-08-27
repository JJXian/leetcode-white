package xian.bishi.baidu0825.T2;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            String op = sc.next();
            char res = battle(a, b, op);
            System.out.println(res);
        }
    }

    public static char battle(int a, int b, String op) {
//        计算a op b 和计算 b op a
        double res1 = 0;
        double res2 = 0;
        if (op.equals("+")) {
            res1 = a + b;
            res2 = b + a;
        } else if (op.equals("-")) {
            res1 = a - b;
            res2 = b - a;
        } else if (op.equals("*")) {
            res1 = a * b;
            res2 = b * a;
        } else if (op.equals("/")) {
            res1 = a / b;
            res2 = b / a;
        } else if (op.equals("^")) {
            res1 = Math.pow(a, b);
            res2 = Math.pow(b, a);
        }
        if (res1 > res2) {
            return '>';
        } else if (res1 < res2) {
            return '<';
        }
        return '=';
    }
}
