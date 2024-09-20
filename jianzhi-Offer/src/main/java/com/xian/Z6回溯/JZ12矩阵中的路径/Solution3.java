package com.xian.Z6回溯.JZ12矩阵中的路径;

/**
 * @Author: jjxian
 */
public class Solution3 {
    public static void main(String[] args) {
        char[][] board = {
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}
        };
        System.out.println(hasPath(board, "bcced"));
        System.out.println(hasPath(board, "abcb"));
    }

    public static boolean hasPath(char[][] matrix, String word) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == word.charAt(0) && backTrace(matrix, i, j, word, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    static int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static boolean backTrace(char[][] matrix, int i, int j, String word, boolean[][] visited, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || matrix[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        for (int[] direction : directions) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (backTrace(matrix, newX, newY, word, visited, index + 1)) {
                return true;
            }
        }

        visited[i][j] = false;
        return false;
    }

}
