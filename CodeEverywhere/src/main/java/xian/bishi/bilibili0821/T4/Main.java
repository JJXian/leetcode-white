package xian.bishi.bilibili0821.T4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int res = count(n, m);
        System.out.println(res);
    }

    static List<Integer> help = new ArrayList<>();
    static int path;

    public static int count(int n, int m) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 10);
            n = n / 10;
        }
        int[] nums = new int[list.size()];
        int index = 0;
        for (Integer num : list) {
            nums[index++] = num;
        }
        backTrack(nums, 0);
        for (Integer x : help) {
            if (x % m == 0) {
                count++;
            }
        }

        return count;
    }

    public static void backTrack(int[] nums, int start) {
        if (start == nums.length) {
            if (path != 0) { // 避免加入空的路径
                help.add(path);
            }
            return;
        }

        // 不选择当前元素
        backTrack(nums, start + 1);

        // 选择当前元素
        path = path * 10 + nums[start];
        backTrack(nums, start + 1);
        path = path / 10; // 回溯到上一个状态
    }
}