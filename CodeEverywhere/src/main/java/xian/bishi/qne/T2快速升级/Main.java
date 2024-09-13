package xian.bishi.qne.T2快速升级;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long[] task = new long[(int) n];
        long[] card = new long[(int) n];
        for (int i = 0; i < n; i++) {
            task[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            card[i] = sc.nextLong();
        }
        int res = minestDay(task, card, m);
        System.out.println(res);
    }

    public static int minestDay(long[] task, long[] card, long target) {
//        int minDay = 1;
        for (int i = 1; i <= task.length; i++) {
            long[] subTask = new long[i];
            long[] subCard = new long[i];

            for (int j = 0; j < i; j++) {
                subTask[j] = task[j];
                subCard[j] = card[j];
            }
            Arrays.sort(subTask);
            Arrays.sort(subCard);
            long sum = 0;
            for (int t = 0; t < i; t++) {
                sum += subTask[t] * subCard[t];
            }
            if (sum >= target) {
                return i;
            }
        }
        return -1;
    }
}
