package T200岛屿数量;

/**
 * @Author: jjxian
 */
public class Solution {
    public int numsOfIsland(char[][] grid){
//        判断图是否为空
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int islandNum = 0;
//        深度优先遍历图，为1的话 islandNum++
        for(int i = 0;i<grid.length;i++){
            for(int j= 0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    islandNum++;
                    dfs(grid,i,j);
                }
            }
        }
        return islandNum;

    }
    private void dfs(char[][] grid, int i,int j){
//        判断是否在图中，不在则返回
        if(i<0 || j<0 || i>=grid.length || j >= grid[0].length || grid[i][j] =='0'){
            return ;
        }
//        已经遍历的修改为0  陆地沉没法
        grid[i][j] = '0';
//        递归遍历相邻的上下左右
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }

    public static void main(String[] args){
        Solution so = new Solution();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int result = so.numsOfIsland(grid);
        System.out.println(result); // 输出 3
    }

}
