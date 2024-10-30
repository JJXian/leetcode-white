package bishi;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jjxian
 */
public class test {
    private String name = "abc";

    public static void main(String[] args) {
        test a = new test();
        test b = new test();
        System.out.println(a.equals(b));
        System.out.println(a.name == b.name);
        System.out.println(a.name.equals(b.name));

    }


    public static int binarySort(int[] nums, int target) {
        int left = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) % 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}

