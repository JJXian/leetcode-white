package xian.bishi.xc0919.T3;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        int[] power = new int[n];
        for (int i = 0; i < n; i++) {
            power[i] = sc.nextInt();
        }
        int res = game(power, k, l);
        System.out.println(res);


    }

    public static int game(int[] power, int k, int l) {
        int[] nums = Arrays.copyOfRange(power, 0, power.length);
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            int target = nums[i];

        }

        return 10;
    }

}
