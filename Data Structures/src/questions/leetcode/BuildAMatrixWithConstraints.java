package questions.leetcode;

import java.util.*;

public class BuildAMatrixWithConstraints {
    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> orderRows = topologicalSort(k, rowConditions);
        List<Integer> orderCols = topologicalSort(k, colConditions);

        if (orderRows.isEmpty() || orderCols.isEmpty()) {
            return new int[0][0];
        }

        int[][] matrix = new int[k][k];
        Map<Integer, Integer> posRow = new HashMap<>();
        Map<Integer, Integer> posCol = new HashMap<>();

        for (int i=0; i<orderRows.size(); i++) {
            posRow.put(orderRows.get(i), i);
        }

        for (int i=0; i<orderCols.size(); i++) {
            posCol.put(orderCols.get(i), i);
        }

        for (int num = 1; num <= k; num++) {
            if (posRow.containsKey(num) && posCol.containsKey(num)) {
                matrix[posRow.get(num)][posCol.get(num)] = num;
            }
        }
        return matrix;
    }

    public static List<Integer> topologicalSort(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        List<Integer> order = new ArrayList<>();
        int[] visited = new int[n + 1];

        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0 && dfs(i, adj, visited, order)) {
                return Collections.emptyList();
            }
        }

        Collections.reverse(order);
        return order;
    }

    public static boolean dfs(int node, Map<Integer, List<Integer>> adj, int[] visited, List<Integer> order) {
        visited[node] = 1;

        if (adj.containsKey(node)) {
            for (int neighbor : adj.get(node)) {
                if (visited[neighbor] == 0) {
                    if (dfs(neighbor, adj, visited, order)) return true;
                } else if (visited[neighbor] == 1) {
                    return true;
                }
            }
        }

        visited[node] = 2;
        order.add(node);
        return false;
    }
}
