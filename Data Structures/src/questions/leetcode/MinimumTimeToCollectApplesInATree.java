package questions.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumTimeToCollectApplesInATree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return dfs(0, -1, graph, hasApple);
    }

    public int dfs(int node, int parent, Map<Integer, List<Integer>> graph, List<Boolean> hasApple) {
        if (!graph.containsKey(node)) {
            return 0;
        }

        int total = 0;
        int childTime = 0;
        for (int child: graph.get(node)) {
            if (child == parent) {
                continue;
            }
            childTime = dfs(child, node, graph, hasApple);
            if (childTime > 0 || hasApple.get(child)) {
                total += childTime + 2;
            }
        }
        return total;
    }
}
