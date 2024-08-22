package xian.bishi.bilibili0821.T1;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int res = count(s);
        System.out.println(res);

    }

    public static int count(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int left = 0;
        int right = s.length() / 2;
        int count = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (str[left] != str[right]) {
                count++;
            }
            left++;
            right++;
        }
        return count;


    }
}
