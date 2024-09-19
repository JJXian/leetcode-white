package xian.practise.T3根据路径创建图;

import java.util.*;

public class GraphTraversal {
    // 使用邻接表表示图
    private Map<Integer, List<Integer>> graph;

    public GraphTraversal() {
        graph = new HashMap<>();
    }

    // 构造图，添加边
    public void addEdge(int u, int v) {
        // 无向图：双向添加边
        graph.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
    }

    // 深度优先遍历 (DFS)
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS Traversal: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    // DFS 递归辅助函数
    private void dfsHelper(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    // 广度优先遍历 (BFS)
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // 测试用例
    public static void main(String[] args) {
        GraphTraversal graphTraversal = new GraphTraversal();
        graphTraversal.addEdge(1, 2);
        graphTraversal.addEdge(1, 3);
        graphTraversal.addEdge(2, 4);
        graphTraversal.addEdge(3, 5);
        graphTraversal.addEdge(4, 5);
        graphTraversal.addEdge(4, 6);

        // 深度优先遍历
        graphTraversal.dfs(1);

        // 广度优先遍历
        graphTraversal.bfs(1);
    }
}