package com.xian.Z6回溯.JZ12矩阵中的路径;

/**
 * @Author: jjxian
 */
public class Solution {

    public static void main(String[] args) {
        Solution so = new Solution();
        char[][] board = {
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}
        };
        System.out.println(so.hasPath(board, "bcced"));
        System.out.println(so.hasPath(board, "abcb"));
    }

    public boolean hasPath(char[][] matrix, String word) {
        int[][] used = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (backTrace(matrix, word, used, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTrace(char[][] matrix, String word, int[][] used, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length
                || used[row][col] == 1 || matrix[row][col] != word.charAt(index)) {
            // 越界、已访问或字符不匹配
            return false;
        }

        // 标记为已访问
        used[row][col] = 1;

        boolean flag = backTrace(matrix, word, used, row + 1, col, index + 1) ||
                backTrace(matrix, word, used, row - 1, col, index + 1) ||
                backTrace(matrix, word, used, row, col + 1, index + 1) ||
                backTrace(matrix, word, used, row, col - 1, index + 1);
        if (flag) {
            return true;
        }
        // 回溯，撤销访问标记
        used[row][col] = 0;
        return false;
    }


    public boolean hasPath2(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        int[][] vidited = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, word, i, j, vidited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int x, int y, int[][] visited, int index) {
        if (index == word.length()) {
            return true;
        }

        if (x < 0 || x > board.length || y < 0 || y > board[0].length) {
            return false;
        }
        visited[x][y] = 1;

        boolean find = dfs(board, word, x + 1, y, visited, index + 1) ||
                dfs(board, word, x - 1, y, visited, index + 1) ||
                dfs(board, word, x, y + 1, visited, index + 1) ||
                dfs(board, word, x, y - 1, visited, index + 1);
        if (find) {
            return true;
        }

        visited[x][y] = 0;
        return false;

    }
}
