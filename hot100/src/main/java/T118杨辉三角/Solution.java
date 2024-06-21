package T118杨辉三角;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-21
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input the numRow :");
        int numRow = sc.nextInt();
        List<List<Integer>> res = generate(numRow);
        for(List<Integer> x : res){
            System.out.println(x);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if(numRows == 0 ){
            return res;
        }

        List<Integer> node = new ArrayList<>();
        node.add(1);
        res.add(node);

        for(int i = 1;i<numRows;i++){
            List<Integer> preRow = res.get(i-1);
            List<Integer> thisRow = new ArrayList<>();
//            首个是1
            thisRow.add(1);
            for(int j = 1;j<i;j++) {
                thisRow.add(preRow.get(j-1) + preRow.get(j));
            }
            thisRow.add(1);
            res.add(thisRow);
        }
        return res;


    }
}
