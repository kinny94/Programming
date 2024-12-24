package questions.leetcode;

import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) {
            return false;
        }

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge: edges) {
            int source = edge[0];
            int destination = edge[1];
            adjList.putIfAbsent(source, new ArrayList<>());
            adjList.putIfAbsent(destination, new ArrayList<>());
            adjList.get(source).add(destination);
            adjList.get(destination).add(source);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            List<Integer> neighbors = adjList.getOrDefault(current, new ArrayList<>());
            for (int neighbor: neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return visited.size() == n;
    }
}
