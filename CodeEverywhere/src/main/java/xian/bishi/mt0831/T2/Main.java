package xian.bishi.mt0831.T2;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] workers = new int[n];
        for (int i = 0; i < n; i++) {
            workers[i] = sc.nextInt();
        }
        int[] road = new int[workers[n - 1] + k];
        int count = 0;
        for (int i = 1; i <= k; i++) {
            // 每一个工人
            for (int j = 0; j < n; j++) {
                int time = i - 1;
                while (time >= 0) {
//                    种树
                    road[workers[j] + time] = 1;
                    time--;
                }
            }
            count = countOne(road);
            if (count >= k) {
                System.out.println(i);
                break;
            }
        }
        sc.close();

    }

    public static int countOne(int[] nums) {
        int count = 0;
        for (int n : nums) {
            if (n == 1) {
                count++;
            }
        }
        return count;
    }
}
