package xian.bishi.zijie18.T1用户喜好;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        用户数
        int n = sc.nextInt();
        int[] likes = new int[n];
//        存储喜欢的值
        for (int i = 0; i < n; i++) {
            likes[i] = sc.nextInt();
        }
//        查询组数
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();
            int res = findK(likes, l, r, k);
            System.out.println(res);
        }

    }

    public static int findK(int[] likes, int l, int r, int k) {
        int count = 0;
        for (int i = l - 1; i < r; i++) {
            if (likes[i] == k) {
                count++;
            }
        }
        return count;
    }

}
