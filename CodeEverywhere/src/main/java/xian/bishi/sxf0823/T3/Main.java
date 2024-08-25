package xian.bishi.sxf0823.T3;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // 去掉输入字符串的左右括号
        input = input.substring(1, input.length() - 1);

        // 按照逗号分割字符串，生成一个包含整数的列表
        String[] nums = input.split(",");
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.parseInt(nums[i].trim());
            System.out.println(arr[i]);
        }
//
//        List<Integer> list = new ArrayList<>();
//        for (String num : nums) {
//            list.add(Integer.parseInt(num.trim()));
//        }
//
//        // 打印列表内容以确认转换结果
//        System.out.println(list);
    }
}
