package xian.practise.T3根据路径创建图;

/**
 * @Author: jjxian
 */

import java.util.*;

public class Graph {
    // 定义一个邻接表的Map，节点名(String) -> 邻接节点列表(List<String>)
    private Map<String, List<String>> adjList;

    // 构造函数初始化图
    public Graph() {
        adjList = new HashMap<>();
    }

    // 添加一条边到图中
    public void addEdge(String from, String to) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.get(from).add(to);
    }

    // 查找图中最长路径
    public List<String> findLongestPath() {
        Set<String> visited = new HashSet<>();  // 记录访问过的节点
        Map<String, List<String>> memo = new HashMap<>();  // 记忆化存储每个节点的最长路径
        List<String> longestPath = new ArrayList<>();  // 最长路径

        for (String node : adjList.keySet()) {
            List<String> currentPath = dfs(node, visited, memo);
            if (currentPath.size() > longestPath.size()) {
                longestPath = currentPath;
            }
        }

        return longestPath;
    }

    // 深度优先搜索，返回从当前节点开始的最长路径
    private List<String> dfs(String node, Set<String> visited, Map<String, List<String>> memo) {
        if (memo.containsKey(node)) {
            return memo.get(node);  // 如果已经计算过该节点的最长路径，直接返回
        }

        visited.add(node);  // 标记节点为访问过
        List<String> longestPath = new ArrayList<>();
        longestPath.add(node);  // 当前节点加入路径

        for (String neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                List<String> neighborPath = dfs(neighbor, visited, memo);
                if (neighborPath.size() > longestPath.size() - 1) {
                    // 重置为当前节点
                    longestPath = new ArrayList<>();
                    longestPath.add(node);  // 当前节点加入路径
                    longestPath.addAll(neighborPath);  // 追加邻居节点的最长路径
                }
            }
        }

        visited.remove(node);  // 回溯时移除节点
        memo.put(node, longestPath);  // 记忆化存储当前节点的最长路径
        return longestPath;
    }


    // 解析多级路径并构建图
    public void addPath(String path) {
        String[] nodes = path.split("->");  // 按 "->" 分割路径
        for (int i = 0; i < nodes.length - 1; i++) {
            String from = nodes[i].trim();   // 当前节点
            String to = nodes[i + 1].trim(); // 下一个节点
            addEdge(from, to);               // 添加边
        }
    }

    // 打印图的邻接表
    public void printGraph() {
        for (String node : adjList.keySet()) {
            System.out.println(node + " -> " + adjList.get(node));
        }
    }

    // 主函数，测试多级路径创建图
    public static void main(String[] args) {
        // 示例输入多级路径
        String[] paths = {"A->B->C", "B->F->G", "A->D->E"};

        // 创建图
        Graph graph = new Graph();

        // 解析每条路径并添加到图中
        for (String path : paths) {
            graph.addPath(path);
        }

        // 打印创建好的图
        graph.printGraph();

        // 查找并打印最长路径
        List<String> longestPath = graph.findLongestPath();
        System.out.println("最长路径: " + longestPath);
    }
}