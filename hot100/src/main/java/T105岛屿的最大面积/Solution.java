package T105岛屿的最大面积;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        //图为空 返回0
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int max = 0; // 初始化为 0
        int rows = grid.length;
        int cols = grid[0].length;
        // dfs搜索岛屿 max记录最大 curMax记录当前最大 遍历过的设置为0
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    int curMax = dfs(grid, i, j);
                    max = Math.max(curMax, max);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j){
        // 不在图中 或者 已经是水了 返回0
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }

        // 遍历过了 设置为0
        grid[i][j] = 0;

        // 记录最大面积，当前节点为1，继续递归搜索四个方向
        int up = dfs(grid, i + 1, j);
        int down = dfs(grid, i - 1, j);
        int left = dfs(grid, i, j - 1);
        int right = dfs(grid, i, j + 1);

        return 1 + up + down + left + right; // 当前节点的面积为1，加上四个方向的面积
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入行数：");
        int rows = scanner.nextInt();
        System.out.println("请输入列数：");
        int cols = scanner.nextInt();

        int[][] grid = new int[rows][cols];

        System.out.println("请输入网格：");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
//
//        int[][] grid = {
//                {0,0,1,0,0,0,0,1,0,0,0,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                {0,1,0,0,1,1,0,0,1,0,1,0,0},
//                {0,1,0,0,1,1,0,0,1,1,1,0,0},
//                {0,0,0,0,0,0,0,0,0,0,1,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,0,0,0,0,0,0,1,1,0,0,0,0}
//        };
        int result = sol.maxAreaOfIsland(grid);
        System.out.println(result); // 输出最大岛屿面积
    }
}
