package T54螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = so.spiralOrder(matrix);
        for (Integer num : list) {
            System.out.println(num);
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = col - 1, up = 0, down = row - 1;
        while (left <= right && up <= down) {
            int i = left;
            while (i < right) {
                res.add(matrix[up][i]);
                i++;
            }
            i = up;
            while (i < down) {
                res.add(matrix[i][right]);
                i++;
            }
            i = right;
            while (i > left) {
                res.add(matrix[down][i]);
                i--;
            }
            i = down;
            while (i > up) {
                res.add(matrix[i][left]);
                i--;
            }
            left++;
            right--;
            up++;
            down--;
        }
        return res;
    }

}
