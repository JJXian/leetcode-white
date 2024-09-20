package xian.bishi.xc0919.T1;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[][] nums = new int[n][m];
            init(nums);
            int res = findRes(nums, k);
            System.out.println(res);

        }
    }

    public static int findRes(int[][] nums, int k) {
        int value = 0;
        int curX = 0, curY = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//        k步
        for (int i = 0; i < k; i++) {
            int newX = curX, newY = curY;
            int max = 0;
            for (int[] direction : directions) {
                int x = curX + direction[0];
                int y = curY + direction[1];
//                坐标合法
                if (x >= 0 && x < nums.length && y >= 0 && y < nums[0].length) {
                    if (nums[x][y] > max) {
                        max = nums[x][y];
                        newX = x;
                        newY = y;
                    }
                }
            }
            value += max;
            curX = newX;
            curY = newY;
        }
        return value;
    }

    public static void init(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j] = j + i * nums[0].length;
            }
        }
    }
}


/*

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[][] nums = new int[n][m];
            init(nums);
            int res = findRes(nums, k);
            System.out.println(res);
        }
    }

    public static int findRes(int[][] nums, int k) {
        int value = 0;
        int x = 0, y = 0;
        for (int i = 0; i < k; i++) {
            int up = 0, down = 0, left = 0, right = 0;
            int newX = x, newY = y;
            int max = 0;
            if (x - 1 >= 0) {
                up = nums[x - 1][y];
                if (up > max) {
                    max = up;
                    newX = x - 1;
                    newY = y;
                }
            }
            if (x + 1 < nums.length) {
                down = nums[x + 1][y];
                if (down > max) {
                    max = down;
                    newX = x + 1;
                    newY = y;
                }
            }
            if (y - 1 >= 0) {
                left = nums[x][y - 1];
                if (left > max) {
                    max = left;
                    newY = y - 1;
                    newX = x;
                }
            }
            if (y + 1 < nums[0].length) {
                right = nums[x][y + 1];
                if (right > max) {
                    max = right;
                    newX = x;
                    newY = y + 1;
                }
            }
            value += max;
            x = newX;
            y = newY;

        }
        return value;
    }

    public static void init(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j] = j + i * nums[0].length;
            }
        }
    }
}
*/
