package T240搜索二维矩阵2;

import java.util.Scanner;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-20
 */
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入m行n列的m,n：");
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println("请输入矩阵的值：");
        int[][] matrix = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j= 0;j<n;j++){
                int x = sc.nextInt();
                matrix[i][j] = x;
            }
        }
        System.out.println("input the target:");
        int tartget = sc.nextInt();
        boolean f  = searchMatrix(matrix,tartget);
        System.out.println("结果是："+f);

    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        // 一行一行的使用二分查找法
        for(int[] row:matrix){
            int index = search(row,target);
            if(index>=0){
                return true;
            }
        }
        return false;

        // 从尾部向前查找
        //  int row = matrix.length;
        // int col = matrix[0].length;
        // int x = 0;
        // int y = col - 1;

        // while (x < row && y >= 0) {
        //     if (matrix[x][y] == target) return true;
        //     if (matrix[x][y] > target) {
        //         y -= 1;
        //     } else x += 1;
        // }
        // return false;


        // 暴力法指定没问题
        // for(int i = 0;i<matrix.length;i++){
        //     for(int j = 0;j<matrix[0].length;j++){
        //         if(target == matrix[i][j]){
        //             return true;
        //         }
        //     }
        // }
        // return false;
    }

    public static int search(int[] nums,int target){
        int low = 0,high = nums.length-1;
        while(low<=high){
            // int mid = (high-low)/2 +low;
            int mid = (low+high)/2;
            int num = nums[mid];
            if(num == target){
                return mid;
            }else if(num < target){
                low = mid +1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}
