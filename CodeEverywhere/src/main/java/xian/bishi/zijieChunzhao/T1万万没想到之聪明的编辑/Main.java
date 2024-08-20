package xian.bishi.zijieChunzhao.T1万万没想到之聪明的编辑;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            String s = updateStr(str);
            System.out.println(s);
        }
    }

    public static String updateStr(String str) {
        if (str.length() < 3) {
            return str;
        }
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
//        三个同样的字母 去掉一个

        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 2 && chars[i] == chars[i + 1] && chars[i] == chars[i + 2]) {
                continue;
            }
            sb.append(chars[i]);
        }
        chars = sb.toString().toCharArray();
        // 清空 StringBuilder
        sb.setLength(0);

        sb.append(chars[0]);
//        AABB型去掉第一个B
        for (int i = 1; i < chars.length; i++) {
            sb.append(chars[i]);
            if (i < chars.length - 2 && chars[i] == chars[i - 1]) {
                int j = i + 1;
                if (chars[j] == chars[j + 1]) {
                    chars[j] = 0;
                    i++;
                }
            }
        }
        return sb.toString();
    }

}
