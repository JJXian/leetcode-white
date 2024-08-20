package xian.bishi.dajiang.T1;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[][] array = new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 20, -5}
        };
        int x = so.calculateMinimumHP(array);
        System.out.println(x);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[row - 1][col] = 1;
        dp[row][col - 1] = 1;

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }

}
