package T739每日温度;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-21
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("intput the temperature size:");
        int n = sc.nextInt();
        int[] temperatures = new int[n];
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            temperatures[i] = x;
        }
        int[] answer = dailyTemperatures(temperatures);
        for(int i = 0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int idx = stack.pop();
                answer[i] = i-idx;
            }
            stack.push(i);
        }

        return answer;

    }

}
