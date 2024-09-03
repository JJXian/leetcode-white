package xian.bishi.xm0312.T1偏爱字符串;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[] love = new char[m];
        for (int i = 0; i < m; i++) {
            String ch = sc.next();
            love[i] = ch.charAt(0);
        }
        String str = sc.next();
        char[] s = str.toCharArray();
//        for (int i = 0; i < n; i++) {
//            String ch = sc.next();
//            s[i] = ch.charAt(0);
//        }

        override(s, love);
        for (char c : s) {
            System.out.println(c);
        }

    }

    public static void override(char[] s, char[] love) {
        Set<Character> dict = new HashSet<>();
        char[] first = Arrays.copyOf(s, s.length);
        for (char c : love) {
            dict.add(c);
        }
        for (int i = 0; i < s.length; i++) {
            char ch = s[i];
            if (!dict.contains(ch)) {
//                需要替换
                int left = i;
                while (left >= 0 && !dict.contains(first[left])) {
                    left--;
                }
                int right = i;
                while (right < s.length && !dict.contains(first[right])) {
                    right++;
                }
//                选择左边还是右边
                char curC = first[i];
                if (left >= 0 && i - left <= right - i) {
                    curC = first[left];
                }
                if (right < s.length && right - i < i - left) {
                    curC = first[right];
                }
                s[i] = curC;
            }
        }
    }
}
