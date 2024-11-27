package algorithms.Graph;

import java.util.*;

public class Kosaraju {

    private int[][] graph; // Original graph
    private int vertices; // Number of vertices
    private boolean[] visited; // Visited array for DFS
    private Stack<Integer> finishOrder; // Stack to store the finish order
    private List<List<Integer>> sccList; // List to store strongly connected components (SCCs)

    // Constructor initializes the graph and other necessary properties
    public Kosaraju(int[][] graph) {
        this.graph = graph;
        this.vertices = graph.length;
        this.visited = new boolean[vertices];
        this.finishOrder = new Stack<>();
        this.sccList = new ArrayList<>();
    }

    // A single DFS method that can work on either original or reversed graph
    private void dfs(int node, int[][] graph, List<Integer> component) {
        visited[node] = true;
        if (component != null) {
            component.add(node); // Add to the component list if it's not null
        }

        // Explore all neighbors
        for (int neighbor = 0; neighbor < vertices; neighbor++) {
            if (graph[node][neighbor] == 1 && !visited[neighbor]) {
                dfs(neighbor, graph, component);
            }
        }

        // After finishing the exploration of the node, push to finishOrder stack (for the original graph)
        if (component == null) {
            finishOrder.push(node); // Add node to finish order for topological sorting
        }
    }

    // Reverse the graph (Transpose)
    private int[][] reverseGraph() {
        int[][] reversedGraph = new int[vertices][vertices];

        // Reverse all edges
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (graph[i][j] == 1) {
                    reversedGraph[j][i] = 1;
                }
            }
        }

        return reversedGraph;
    }

    // Kosaraju's algorithm to find strongly connected components (SCCs)
    public void kosaraju() {
        // Step 1: Perform DFS on the original graph and store the finish order
        Arrays.fill(visited, false); // Reset visited array before the first DFS
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, graph, null);  // Perform DFS on the original graph to fill the finish order
            }
        }

        // Step 2: Reverse the graph
        int[][] reversedGraph = reverseGraph();

        // Step 3: Perform DFS on the reversed graph in the order of the finish time
        Arrays.fill(visited, false); // Reset visited array for second DFS
        while (!finishOrder.isEmpty()) {
            int node = finishOrder.pop();
            if (!visited[node]) {
                List<Integer> component = new ArrayList<>();
                dfs(node, reversedGraph, component);  // Perform DFS on the reversed graph
                sccList.add(component); // Add the component to the SCC list
            }
        }
    }

    // Print the strongly connected components (SCCs)
    public void printSolution() {
        System.out.println("Strongly Connected Components (SCCs):");
        for (List<Integer> component : sccList) {
            System.out.println(component);
        }
    }

    public static void main(String[] args) {
        // Example graph
        int[][] graph = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0}
        };

        Kosaraju kosaraju = new Kosaraju(graph);
        kosaraju.kosaraju();
        kosaraju.printSolution();
    }
}
