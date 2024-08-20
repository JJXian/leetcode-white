package xian.bishi.zijieChunzhao.T2万万没想到之抓捕孔连顺;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[] site = new int[N];
        for (int i = 0; i < N; i++) {
            site[i] = sc.nextInt();
        }

        long res = findWay(site, D);
        System.out.println(res);
    }


    public static long findWay(int[] site, int minDis) {
//        两个特工最远距离为minDis
        long count = 0;

        for (int i = 0; i < site.length - 2; i++) {
            int j = i + 2;
//            找到最右边的特工范围
            while (site[j] - site[i] <= minDis) {
                j++;
            }
            // j - 1 是最后一个符合条件的位置
            if (j - i - 1 >= 2) { // 需要有至少两个位置
                int n = j - i - 1;
                count += (long) (n - 1) * n / 2;
            }
        }
        return count;
    }


}
