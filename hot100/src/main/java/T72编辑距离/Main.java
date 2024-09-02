package T72编辑距离;

/**
 * @Author: jjxian
 */
public class Main {

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int res = minDistance(word1, word2);
        System.out.println(res);
    }


    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 创建dp数组，dp[i][j]表示word1[0...i-1]和word2[0...j-1]之间的最小步数
        int[][] dp = new int[n + 1][m + 1];

        // 初始化
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;  // word2为空字符串时的编辑距离
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;  // word1为空字符串时的编辑距离
        }

        // 填充dp数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];  // 字符相等时不需要删除
                } else {
                    // 否则 取删除、修改、和添加中最小的操作次数+1
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }

        return dp[n][m];  // 返回最终的编辑距离
    }
}
