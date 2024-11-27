package algorithms.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArticulationPointAndBridges {

    public boolean[] visited;
    public int[] discoveryTime;
    public int[] lowestTime;
    public int[][] graph;
    public int time;
    public Set<Integer> articulationPoints;
    public List<int[]> bridges;

    public ArticulationPointAndBridges(int[][] graph) {
        this.graph = graph;
        visited = new boolean[graph.length];
        discoveryTime = new int[graph.length];
        lowestTime = new int[graph.length];
        bridges = new ArrayList<>();
        articulationPoints = new HashSet<>();
        time = 0;
    }

    public void dfs(int current, int parent) {
        visited[current] = true;
        discoveryTime[current] = lowestTime[current] = time++;
        int childCount = 0;

        for (int neighbor = 0; neighbor < graph.length; neighbor++) {
            if (graph[current][neighbor] == 0) continue; // Skip if no edge exists

            if (!visited[neighbor] && graph[current][neighbor] != 0) {
                dfs(neighbor, current);
                childCount++;

                lowestTime[current] = Math.min(lowestTime[current], lowestTime[neighbor]); // dp table for calculating min

                // Check for bridge
                if (lowestTime[neighbor] > discoveryTime[current]) {
                    bridges.add(new int[]{current, neighbor});
                }

                // Check for articulation point
                if (parent != -1 && lowestTime[neighbor] >= discoveryTime[current]) {
                    articulationPoints.add(current);
                }
            } else if (neighbor != parent) { // Back edge
                lowestTime[current] = Math.min(lowestTime[current], discoveryTime[neighbor]);
            }
        }

        // Root node articulation point check
        if (parent == -1 && childCount > 1) {
            articulationPoints.add(current);
        }
    }

    public void findArticulationPointsAndBridges() {
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(i, -1);
            }
        }
    }

    public void printSolution() {
        System.out.println("Articulation Points:");
        for (int ap : articulationPoints) {
            System.out.println(ap);
        }

        System.out.println("Bridges:");
        for (int[] bridge : bridges) {
            System.out.println(bridge[0] + " - " + bridge[1]);
        }
    }

    public static int[][] convertToAdjacencyMatrix(int[][] edges, int maxNode) {
        int[][] matrix = new int[maxNode + 1][maxNode + 1];
        for (int[] edge : edges) {
            int u = edge[0] - 1; // Convert 1-based to 0-based indexing
            int v = edge[1] - 1;
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }
        return matrix;
    }

    public static void main(String[] args) {

        int[][] graph2 = {
                {0, 1, 1, 0, 0, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0}
        };

        int[][] graph = {
                {0, 1, 1, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 1, 1},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0}
        };

        ArticulationPointAndBridges articulationPointAndBridges = new ArticulationPointAndBridges(graph);
        articulationPointAndBridges.findArticulationPointsAndBridges();
        articulationPointAndBridges.printSolution();

        System.out.println();

        ArticulationPointAndBridges articulationPointAndBridges2 = new ArticulationPointAndBridges(graph2);
        articulationPointAndBridges2.findArticulationPointsAndBridges();
        articulationPointAndBridges2.printSolution();
    }
}
