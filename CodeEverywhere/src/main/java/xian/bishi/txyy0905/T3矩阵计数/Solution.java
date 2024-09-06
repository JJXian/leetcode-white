package xian.bishi.txyy0905.T3矩阵计数;

/**
 * @Author: jjxian
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 返回一个整数，表示答案
     *
     * @param a   int整型ArrayList<ArrayList<>>
     * @param val int整型
     * @return int整型
     */
    public static int matrixCount(String[] a, int val) {
        int count = 0;
        char[][] grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            char[] chars = a[i].toCharArray();
            grid[i][0] = chars[0];
            grid[i][1] = chars[1];
            grid[i][2] = chars[2];
        }

        int rNum = 0, eNum = 0, dNum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (grid[i][j] == 'r') {
                    rNum++;
                } else if (grid[i][j] == 'e') {
                    eNum++;
                } else {
                    dNum++;
                }
            }
        }
        int num = Math.min(rNum, Math.min(eNum, dNum));
        if (num >= val) {
            count++;
        }

        rNum = 0;
        eNum = 0;
        dNum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 3; j++) {
                if (grid[i][j] == 'r') {
                    rNum++;
                } else if (grid[i][j] == 'e') {
                    eNum++;
                } else {
                    dNum++;
                }
            }
        }
        num = Math.min(rNum, Math.min(eNum, dNum));
        if (num >= val) {
            count++;
        }

        rNum = 0;
        eNum = 0;
        dNum = 0;
        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (grid[i][j] == 'r') {
                    rNum++;
                } else if (grid[i][j] == 'e') {
                    eNum++;
                } else {
                    dNum++;
                }
            }
        }
        num = Math.min(rNum, Math.min(eNum, dNum));
        if (num >= val) {
            count++;
        }

        rNum = 0;
        eNum = 0;
        dNum = 0;
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (grid[i][j] == 'r') {
                    rNum++;
                } else if (grid[i][j] == 'e') {
                    eNum++;
                } else {
                    dNum++;
                }
            }
        }
        num = Math.min(rNum, Math.min(eNum, dNum));
        if (num >= val) {
            count++;
        }

        rNum = 0;
        eNum = 0;
        dNum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 'r') {
                    rNum++;
                } else if (grid[i][j] == 'e') {
                    eNum++;
                } else {
                    dNum++;
                }
            }
        }
        num = Math.min(rNum, Math.min(eNum, dNum));
        if (num >= val) {
            count++;
        }


//        for (int i = 2; i <= 3; i++) {
//            for (int j = 0; j <= 3 - i; j++) {
//                int rNum = 0, eNum = 0, dNum = 0;
//                for (int row = 0; row < j + i; row++) {
//                    for (int col = 0; col < j + i; col++) {
//                        if (grid[row][col] == 'r') {
//                            rNum++;
//                        } else if (grid[row][col] == 'e') {
//                            eNum++;
//                        } else {
//                            dNum++;
//                        }
//                    }
//                }
//                int num = Math.min(rNum, Math.min(eNum, dNum));
//                if (num >= val) {
//                    count++;
//                }
//            }
//        }
        return count;
    }


    public static void main(String[] args) {
        String[] a = {"red", "edr", "dre"};
        int count = matrixCount(a, 1);
        System.out.println(count);
    }


}
