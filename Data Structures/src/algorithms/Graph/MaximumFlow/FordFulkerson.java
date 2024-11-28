package algorithms.Graph.MaximumFlow;

import java.util.Stack;

public class FordFulkerson {

    public int[][] capacity;
    public int[][] residual;
    public int vertices;

    public FordFulkerson(int vertices) {
        this.vertices = vertices;
        this.capacity = new int[vertices][vertices];
        this.residual = new int[vertices][vertices];
    }

    public void addEdge(int source, int target, int cap) {
        capacity[source][target] = cap;
        residual[source][target] = cap; // Initially, residual capacity is the same as capacitry
    }

    private boolean dfs(int source, int sink, int[] parent) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        visited[source] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();

            for (int neighbor=0; neighbor<vertices; neighbor++) {
                if (!visited[neighbor] && residual[current][neighbor] > 0) { // Edge with positive residual capacity
                    parent[neighbor] = current;
                    visited[neighbor] = true;

                    if (neighbor == sink) {
                        return true; // Augmented path found!
                    }
                    stack.push(neighbor);
                }
            }
        }

        return false; // Can't find a path
    }

    public int maxFlow(int source, int sink) {
        int maxFlow = 0;
        int[] parent = new int[vertices];

        // Augment the flow while there is a path
        while(dfs(source, sink, parent)) {
            // Find the minimum capacity of the augmented path
            int pathFlow = Integer.MAX_VALUE;
            int current = sink;
            while (current != source) {
                int prev = parent[current];
                pathFlow = Math.min(pathFlow, residual[prev][current]);
                current = prev;
            }
            // update the residual capacities and reverse flow along the path
            current = sink;
            while (current != source) {
                int prev = parent[current];
                residual[prev][current] -= pathFlow;
                residual[current][prev] += pathFlow; // Add reverse flow
                current = prev;
            }
            maxFlow += pathFlow;
        }
        return maxFlow;
    }

    public static void main(String[] args) {
        // Example: Graph with 6 vertices
        FordFulkerson ff = new FordFulkerson(6);

        // Adding edges with capacities
        ff.addEdge(0, 1, 16);
        ff.addEdge(0, 2, 13);
        ff.addEdge(1, 2, 10);
        ff.addEdge(1, 3, 12);
        ff.addEdge(2, 1, 4);
        ff.addEdge(2, 4, 14);
        ff.addEdge(3, 2, 9);
        ff.addEdge(3, 5, 20);
        ff.addEdge(4, 3, 7);
        ff.addEdge(4, 5, 4);

        int source = 0; // Source node
        int sink = 5;   // Sink node

        System.out.println("The maximum possible flow is: " + ff.maxFlow(source, sink));
    }
}
