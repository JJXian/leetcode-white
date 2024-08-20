package xian.bishi.zijie23.T4极长连续段的权值;

import java.util.Scanner;

/**
 * 暴力法超时
 *
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

//        暴力法
        int res = countValue2(str);
//        System.out.println(res);
//        动态规划
        long r = count(str);
        System.out.println(r);
    }

    public static long count(String str) {
        int n = str.length();
        char[] ch = str.toCharArray();
        if (n == 1) {
            return 1;
        }

        long res = 1L;
        long pre = 1L;
        for (int i = 1; i < n; i++) {
            //加上本身这个长度为1的子段。
            pre += 1;
            //如果元素跟前一个不同 那再多i个
            if (ch[i] != ch[i - 1]) {
                pre += i;
            }
            res += pre;
        }
        return res;

    }

    /**
     * 暴力法
     *
     * @param str
     * @return
     */
    public static int countValue2(String str) {
        int res = 0;
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j <= str.length() - i; j++) {
                String subString = str.substring(j, j + i);
                res += countHelper(subString);
            }
        }
        return res;
    }

    //    计算权值
    public static int countHelper(String str) {
        if (str.length() == 1) {
            return 1;
        }
        char[] s = str.toCharArray();
        int result = 1;
        for (int i = 1; i < str.length(); i++) {
            if (s[i] != s[i - 1]) {
                result++;
            }
        }
        return result;
    }
}


