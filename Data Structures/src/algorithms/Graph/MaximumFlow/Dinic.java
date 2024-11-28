package algorithms.Graph.MaximumFlow;

import java.util.*;

public class Dinic {

    public int[][] capacity;
    public int[][] residualCapacity;
    public int[] level;
    public int vertices;

    public Dinic(int vertices) {
        this.vertices = vertices;
        capacity = new int[vertices][vertices];
        residualCapacity = new int[vertices][vertices];
        level = new int[vertices];
    }

    // add edge
    public void addEdge(int from, int to, int cap) {
        capacity[from][to] += cap; // Add capacity for the edge
        residualCapacity[from][to] += cap; // Initialize residual capacity
    }

    // BFS to construct the level graph
    public boolean bfs(int source, int sink) {
        Arrays.fill(level, -1);
        level[source] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor = 0; neighbor < vertices; neighbor++) {
                // check if edge exists and has residual capacity
                if (level[neighbor] == -1 && residualCapacity[node][neighbor] > 0) {
                    level[neighbor] = level[node] + 1;
                    queue.add(neighbor);
                }
            }
        }
        return level[sink] != -1; // Return true if sink is reachable
    }

    // DFS to send flow in the level graph
    private int dfs(int node, int sink, int flow) {
        if (node == sink) return flow;

        for (int neighbor = 0; neighbor < vertices; neighbor++) {
            // Check if edge is valid in the level graph
            if (level[neighbor] == level[node] + 1 && residualCapacity[node][neighbor] > 0) {
                int bottleneck = dfs(neighbor, sink, Math.min(flow, residualCapacity[node][neighbor]));

                if (bottleneck > 0) { // If flow is possible
                    residualCapacity[node][neighbor] -= bottleneck; // Reduce capacity
                    residualCapacity[neighbor][node] += bottleneck; // Increase reverse capacity
                    return bottleneck;
                }
            }
        }

        return 0; // No flow possible
    }

    public int maxFlow(int source, int sink) {
        int maxFlow = 0;
        while (bfs(source, sink)) { // construct level graph
            int flow;
            while ((flow = dfs(source, sink, Integer.MAX_VALUE)) > 0) {
                maxFlow += flow;
            }
        }
        return maxFlow;
    }

    public static void main(String[] args) {
        // Example: Graph with 6 vertices

        Dinic dinic = new Dinic(6);

        // Adding edges with capacities
        dinic.addEdge(0, 1, 16);
        dinic.addEdge(0, 2, 13);
        dinic.addEdge(1, 2, 10);
        dinic.addEdge(1, 3, 12);
        dinic.addEdge(2, 4, 14);
        dinic.addEdge(3, 2, 9);
        dinic.addEdge(3, 5, 20);
        dinic.addEdge(4, 3, 7);
        dinic.addEdge(4, 5, 4);

        int source = 0; // Source node
        int sink = 5;   // Sink node

        System.out.println("The maximum possible flow is: " + dinic.maxFlow(source, sink));
    }

}



