package xian.bishi.xm0905.T1zhizuomianbao;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] baoA = new int[n];
        int[] baoB = new int[n];
        for (int i = 0; i < n; i++) {
            baoA[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            baoB[i] = sc.nextInt();
        }

        int res = countTime(baoA, baoB, n);
        System.out.println(res);
    }

    public static int countTime(int[] baoA, int[] baoB, int n) {

        int costTime = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tempCost;
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
