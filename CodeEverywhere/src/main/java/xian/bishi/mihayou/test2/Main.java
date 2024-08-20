package xian.bishi.mihayou.test2;

import java.util.Scanner;

/**
 * 测试用例
 * 3 100 2
 * 15 19
 * 20 30
 * 15 19
 * 1 3
 * 2 3
 *
 * @Author: jjxian
 */
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int goodsNum = in.nextInt();
        int bag = in.nextInt();
        int relations = in.nextInt();
        int[][] good = new int[goodsNum][2];
        for (int i = 0; i < goodsNum; i++) {
            good[i][0] = in.nextInt();
            good[i][1] = in.nextInt();
        }
        boolean[][] cannotChooseTogether = new boolean[goodsNum][goodsNum];
        for (int i = 0; i < relations; i++) {
            int a = in.nextInt() - 1; // 物品索引从1开始，转换为从0开始
            int b = in.nextInt() - 1;
            cannotChooseTogether[a][b] = true;
            cannotChooseTogether[b][a] = true;
        }
//        int[][] relate = new int[relations][2];
//        for (int i = 0; i < relations; i++) {
//            relate[i][0] = in.nextInt();
//            relate[i][1] = in.nextInt();
//        }
        int res = findMaxValue(good, bag, cannotChooseTogether);
        System.out.println(res);

    }

    /**
     * 2.	动态规划：
     * •	使用一维数组 dp 表示在不同容量下的最大价值。
     * •	遍历每个物品 i，并从背包的最大容量开始向下遍历容量 j。
     * •	在每次尝试将物品 i 放入背包前，检查是否有与物品 i 互斥的物品已经被选择。如果没有互斥的物品被选择，才进行状态转移。
     *
     * @param goods
     * @param bag
     * @param cannotChooseTogether
     * @return
     */
    public static int findMaxValue(int[][] goods, int bag, boolean[][] cannotChooseTogether) {
        int len = goods.length;
        int[] dp = new int[bag + 1];

        for (int i = 0; i < len; i++) {
            for (int j = bag; j >= goods[i][0]; j--) {
                boolean canChoose = true;

                // 检查当前重量 j - goods[i][0] 对应的选择是否与物品 i 互斥
                for (int k = 0; k < len; k++) {
                    if (dp[j - goods[i][0]] > 0 && cannotChooseTogether[i][k]) {
                        canChoose = false;
                        break;
                    }
                }

                if (canChoose) {
                    dp[j] = Math.max(dp[j], dp[j - goods[i][0]] + goods[i][1]);
                }
            }
        }

        return dp[bag];
    }
}