package xian.bishi.qne.T1最小排列;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        findMin(nums);
//        Arrays.sort(nums);
//        for (int x : nums) {
//            System.out.print(x + " ");
//        }


    }

//    回溯法找到所有的字符串 然后比较字符串 返回最小的那个

    //    static List<String> list = new ArrayList<>();
    static Set<String> set = new HashSet<>();
    static StringBuilder path = new StringBuilder();

    public static int[] findMin(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        backTracking(nums, 0, visited);
        for (String str : set) {
            System.out.println(str);
        }

        return nums;
    }

    public static void backTracking(int[] nums, int index, boolean[] visited) {
        if (index == nums.length) {
            set.add(path.toString());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.append(nums[i]);
                backTracking(nums, index + 1, visited);
                visited[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

}
