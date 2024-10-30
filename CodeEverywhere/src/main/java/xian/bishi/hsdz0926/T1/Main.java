package xian.bishi.hsdz0926.T1;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int max = 0;
        for (int i = num - 1; i > 0; i--) {
            int a = i;
            int b = num - a;
            max = Math.max(max, a * b);
        }
        System.out.println(max);
    }
}
