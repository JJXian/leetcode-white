package bishi.baidu.T3;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] grid = new int[n + 1][n + 1];
        int[] type = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            grid[x][y] = 1;
            grid[y][x] = 1;
        }

        for (int i = 0; i < n; i++) {
            type[i + 1] = sc.nextInt();
        }

        for (int i = 0; i < q; i++) {
            int firstListen = sc.nextInt();
            int[] visited = new int[n + 1];
            count = 1;
            visited[firstListen] = 1;
            influenceNum(grid, firstListen, type, visited);
            System.out.println(count);
        }

    }


    public static void influenceNum(int[][] grid, int i, int[] type, int[] visited) {
//        int count = 1;
        for (int j = 1; j < grid.length; j++) {
//            是朋友
            if (visited[j] != 1) {
                if (grid[i][j] == 1) {
                    if (type[i] == 1 && visited[j] == 0) {
                        count++;
                        visited[j] = 1;
                        influenceNum(grid, j, type, visited);
                    }
                }
//                if (grid[i][j] == 0) {//不是朋友
//                    if (type[i] == 2 && visited[j] == 0) {
//                        count++;
//                        visited[j] = 1;
//                        influenceNum(grid, j, type, visited);
//                    }
//                }

            }


        }
    }
}

/**
 * 5 5 5
 * 1 2
 * 2 3
 * 3 4
 * 4 5
 * 1 5
 * 1 2 1 1 2
 * 1 2 3 4 5
 * <p>
 * <p>
 * 3
 * 1
 * 4
 * 4
 * 1
 */





