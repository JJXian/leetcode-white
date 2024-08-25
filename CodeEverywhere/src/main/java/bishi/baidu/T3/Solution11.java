package bishi.baidu.T3;

import java.util.Scanner;

public class Solution11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] grid = new int[n + 1][n + 1];
        int[] type = new int[n + 1];

        // 初始化图的连接
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            grid[x][y] = 1;
            grid[y][x] = 1;
        }

        // 读取每个节点的类型
        for (int i = 0; i < n; i++) {
            type[i + 1] = sc.nextInt();
        }

        // 处理每一个查询
        for (int i = 0; i < q; i++) {
            int firstListen = sc.nextInt();
            int[] visited = new int[n + 1];
            visited[firstListen] = 1;
            int result = influenceNum(grid, firstListen, type, visited);
            System.out.println(result);
        }
        sc.close();
    }

    public static int influenceNum(int[][] grid, int i, int[] type, int[] visited) {
        int count = 1;
        for (int j = 1; j < grid.length; j++) {
            if (visited[j] != 1 && grid[i][j] == 1 && type[i] == 1) {
                visited[j] = 1;
                count += influenceNum(grid, j, type, visited);
            }
        }
        return count;
    }
}