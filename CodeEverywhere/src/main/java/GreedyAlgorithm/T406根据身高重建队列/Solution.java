package GreedyAlgorithm.T406根据身高重建队列;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-14
 */
public class Solution {

    public static int[][] reconstructQueue(int[][] people) {

        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]); // 身高从大到小排
            } else {
                return Integer.compare(a[1], b[1]); // k 从小到大排
            }
        });
        LinkedList<int[]> que = new LinkedList<>();
        for (int[] p : people) {
            que.add(p[1], p);   //Linkedlist.add(index, value)，會將value插入到指定index裡。
        }
        return que.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入人数：");
        int peopleNum = sc.nextInt();
        int[][] people = new int[peopleNum][2];
        System.out.println("请输入每个人身高和前面比他高的人：");
        for (int i = 0; i < peopleNum; i++) {
            int height = sc.nextInt();
            int num = sc.nextInt();
            people[i][0] = height;
            people[i][1] = num;
        }
        int[][] res = reconstructQueue(people);
        System.out.println("结果：");
        for (int[] person : res) {

            System.out.println(Arrays.toString(person));
        }

    }
}
