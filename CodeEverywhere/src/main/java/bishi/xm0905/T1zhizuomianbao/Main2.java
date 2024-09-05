package bishi.xm0905.T1zhizuomianbao;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        long n = sc.nextLong();
        long[] baoA = new long[n];
        long[] baoB = new long[n];
        for (int i = 0; i < n; i++) {
            baoA[i] = sc.nextLong();
        }

        for (int i = 0; i < n; i++) {
            baoB[i] = sc.nextInt();
        }

        long res = countTime(baoA, baoB, n);
        System.out.println(res);
    }

    public static long countTime(long[] baoA, long[] baoB, int n) {

        long costTime = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long tempCost;
//            使用同一个机器
                if (i == j) {
                    tempCost = baoA[i] + baoB[j];
                } else {
                    tempCost = Math.max(baoA[i], baoB[j]);
                }
                costTime = Math.min(costTime, tempCost);
            }
        }
        return costTime;

    }
}
