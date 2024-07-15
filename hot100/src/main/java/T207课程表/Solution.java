package T207课程表;

/**
 * @Author: jjxian
 */
import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 创建图的邻接表和入度数组
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // 初始化图和入度数组
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }

        // 初始化队列，将所有入度为0的课程加入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;  // 计数已完成课程数

        // 拓扑排序
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int nextCourse : graph.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // 如果完成课程数等于总课程数，则返回 true
        return count == numCourses;
    }

    public static void main(String[] args) {
        Solution cs = new Solution();
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(cs.canFinish(numCourses1, prerequisites1));  // 输出: true

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(cs.canFinish(numCourses2, prerequisites2));  // 输出: false
    }
}