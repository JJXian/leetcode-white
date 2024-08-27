package T994腐烂的橘子;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        Main m = new Main();
        int res = m.orangesRotting(grid);
        System.out.println(res);
    }

    int count = 0;
    int[][] visited;

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        visited = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = 1;
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void bfs(int[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] != 1 || visited[x][y] == 1) {
                continue;
            }
            visited[x][y] = 1;
            grid[x][y] = 2;
        }
    }
}
