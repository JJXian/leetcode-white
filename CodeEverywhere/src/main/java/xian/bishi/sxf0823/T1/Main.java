package xian.bishi.sxf0823.T1;

/**
 * 计算数组的奇数长度的子数组的和
 *
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        int[] num = {1, 4, 2, 5, 3};
        int res = countSum(num);
        System.out.println(res);
    }

    public static int countSum(int[] arr) {
        int sum = 0;
        for (int i = 1; i <= arr.length; i += 2) {
            for (int j = 0; j <= arr.length - i; j++) {
                int[] subArr = new int[i];
                int index = 0;
                for (int k = j; k < j + i; k++) {
                    subArr[index++] = arr[k];
                }
                for (int n : subArr) {
                    System.out.print(n);
                }
                System.out.println();

                sum += help(subArr);
            }
        }
        return sum;
    }

    public static int help(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        return sum;
    }


    public static int youhuahou(int[] arr) {
        int sum = 0;
        for (int i = 1; i <= arr.length; i += 2) { // i为子数组的长度，且为奇数
            for (int j = 0; j <= arr.length - i; j++) { // 从每个位置j开始，选取长度为i的子数组
                int subSum = 0;
                for (int k = j; k < j + i; k++) { // 直接计算子数组的和
                    subSum += arr[k];
                }
                sum += subSum; // 累加到总和
            }
        }
        return sum;
    }
}
