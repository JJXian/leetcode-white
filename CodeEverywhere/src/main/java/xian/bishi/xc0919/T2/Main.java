package xian.bishi.xc0919.T2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int res = game(nums, m, k);
        System.out.println(res);

    }

    public static int game(int[] nums, int m, int k) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }
        boolean flag = true;

        while (flag) {
            flag = false;
//            选择k个元素
            for (int i = 0; i < list.size() - m + 1; i++) {
                int[] temp = new int[m];

                List<Integer> t = list.subList(i, i + m);
                if (t.get(m - 1) - t.get(0) <= k) {
                    list.remove(i);
                    flag = true;
                    break;
                }


//                for (int start = i; start < i + m; start++) {
//                    temp[start - i] = list.get(start);
//                }
//                if (temp[m - 1] - temp[0] <= k) {
//                    list.remove(i);
//                    flag = true;
//                    break;
//                }
            }
            if (flag == false) {
                return list.size();
            }

        }

        return list.size();
    }
}














