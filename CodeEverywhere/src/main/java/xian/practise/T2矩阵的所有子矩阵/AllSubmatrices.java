package xian.practise.T2矩阵的所有子矩阵;

import java.util.ArrayList;
import java.util.List;

public class AllSubmatrices {
    public static void main(String[] args) {
        // 示例输入：4x4矩阵
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int m = 4;  // 子矩阵的大小

        // 获取所有大小为 m*m 的子矩阵
        List<int[][]> submatrices = findSubmatricesOfSizeM(matrix, m);

        // 打印所有子矩阵
        for (int[][] submatrix : submatrices) {
            printMatrix(submatrix);
            System.out.println(); // 每个子矩阵后换行
        }
    }

    // 查找所有大小为 m*m 的子矩阵
    public static List<int[][]> findSubmatricesOfSizeM(int[][] matrix, int m) {
        int n = matrix.length;  // 矩阵的大小是 n*n
        List<int[][]> submatrices = new ArrayList<>();

        // 遍历所有可能的左上角组合 (i1, j1)
        for (int i1 = 0; i1 <= n - m; i1++) {
            for (int j1 = 0; j1 <= n - m; j1++) {
                // 提取子矩阵
                int[][] submatrix = extractSubmatrix(matrix, i1, j1, m);
                submatrices.add(submatrix);
            }
        }

        return submatrices;
    }

    // 提取左上角为 (i1, j1)，大小为 m*m 的子矩阵
    public static int[][] extractSubmatrix(int[][] matrix, int i1, int j1, int m) {
        int[][] submatrix = new int[m][m];

        // 复制 m*m 区域的元素到新矩阵中
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                submatrix[i][j] = matrix[i1 + i][j1 + j];
            }
        }

        return submatrix;
    }

    // 打印矩阵
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}