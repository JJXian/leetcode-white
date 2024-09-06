package xian.bishi.txyy0905.T1buzaizhonger;

import java.util.ArrayList;

/**
 * @Author: jjxian
 */

public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();

        int x = so.deleteTwo(2);
        System.out.println(x);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a int整型ArrayList
     * @return int整型ArrayList
     */
    public ArrayList<Integer> newArray(ArrayList<Integer> a) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : a) {
            int temp = deleteTwo(num);
            if (temp != -1) {
                res.add(temp);
            }
        }
        return res;
    }

    public int deleteTwo(int num) {
        int newNum = 0;
        int wei = 1;
        int curNum;
        boolean flag = false;
        while (num != 0) {
            curNum = num % 10;
            if (curNum != 2) {
                newNum = curNum * wei + newNum;
                wei = wei * 10;
                flag = true;
            }
            num = num / 10;
        }
        if (!flag) {
            return -1;
        }
        return newNum;
    }
}