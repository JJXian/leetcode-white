package xian.bishi.mt0831.T3;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    static int minLen = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = sc.nextInt();
        }

        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            String res = battle(arr, l, r);
            System.out.println(res);
            System.out.println(minLen);
        }

    }

    public static String battle(int[] arr, int l, int r) {
        int tuanChose = Integer.MIN_VALUE;
        int tuanChoseIndex = -1;
        for (int i = l; i <= r; i++) {
            if (arr[i] > tuanChose) {
                tuanChose = arr[i];
                tuanChoseIndex = i;
            }
        }


        int leftMove = 0;
        int L = l;
        while (L >= 1) {
            L--;

            if (L > 1 && arr[L] > tuanChose || arr[L] < tuanChose) {
                break;
            }
            leftMove++;
        }
        int rightMove = 0;
        int R = r;
        while (R < arr.length) {
            R++;
            rightMove++;
            if (R < arr.length && (arr[R] < tuanChose || arr[R] > tuanChose)) {
                break;
            }
        }

        if (leftMove == 0) {
            minLen = r - l + 1 + rightMove;
            if (arr[R] < tuanChose) {
                return "lose";
            } else {
                return "win";
            }
        } else if (rightMove == 0) {
            minLen = r - l + 1 + leftMove;
            if (arr[L] < tuanChose) {
                return "lose";
            } else {
                return "win";
            }
        }
        if (rightMove < leftMove) {
            minLen = r - l + 1 + leftMove;
            if (arr[L] < tuanChose) {
                return "lose";
            } else {
                return "win";
            }
        }

        minLen = r - l + 1 + leftMove;
        if (arr[L] < tuanChose) {
            return "lose";
        }

        return "win";

    }

}
