package xian.bishi.baidu0825.T1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            list.add(s);
        }
        for (int i = 0; i < list.size() - 1; i++) {
            String s1 = list.get(i);
            String s2 = list.get(i + 1);
            double res = countCircle(s1, s2);
            System.out.println(res);
        }
    }

    public static double countCircle(String s1, String s2) {
        int sumOfs1 = 0;
        int sumOfs2 = 0;

        for (int i = 0; i <= 6; i += 3) {
            int time1 = Integer.parseInt(s1.substring(i, i + 2));
            int time2 = Integer.parseInt(s2.substring(i, i + 2));
//          小时
            if (i == 0) {
                sumOfs1 += time1 * 60 * 60;
                sumOfs2 += time2 * 60 * 60;
            } else if (i == 3) {
                sumOfs1 += time1 * 60;
                sumOfs2 += time2 * 60;
            } else {
                sumOfs1 += time1;
                sumOfs2 += time2;
            }

        }

        double all = 24 * 60 * 60;
        double count = 0;
        if (sumOfs2 - sumOfs1 > 0) {
            count = (double) (sumOfs2 - sumOfs1) / 60;
        } else {
            double cha = all - (sumOfs1 - sumOfs2);
            count = cha / 60;
        }

        return count;
    }
}
