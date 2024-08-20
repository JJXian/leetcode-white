package xian.GreedyAlgorithm.T763划分字母区间;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-16
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input the string:");
        String s = sc.nextLine();
        List<Integer> res = partitionLabels(s);
        System.out.println(res);

    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<>();
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
//            edge[i] = chars[i] - 'a';
            edge[chars[i] - 'a'] = i;
        }

        int index = 0;
        int last = -1;//记录上一段字符串的最后位置

        for (int i = 0; i < chars.length; i++) {
            index = Math.max(index, edge[chars[i] - 'a']);
            if (i == index) {//该段字符串划分结束
                res.add(i - last);
                last = i;
            }
        }
        return res;
    }
}
