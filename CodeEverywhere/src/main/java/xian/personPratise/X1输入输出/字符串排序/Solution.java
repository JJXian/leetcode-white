package xian.personPratise.X1输入输出.字符串排序;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            String s = in.nextLine();
//            String[] strs = s.split(" ");
//            Arrays.sort(strs);
//            System.out.println(String.join(" ", strs));
            String[] strs = in.nextLine().split(" ");
            Arrays.sort(strs);
            System.out.println(String.join(" ", strs));
        }
    }
}
