package algorithms.Graph;

import java.util.*;

public class DFSTreeWithBackedge {

    public Map<Integer, List<Integer>> graph;
    public Set<Integer> visited;
    public Set<Integer> ancestors;
    public List<int[]> backedges;

    public DFSTreeWithBackedge() {
        graph = new HashMap<>();
        visited = new HashSet<>();
        ancestors = new HashSet<>();
        backedges = new ArrayList<>();
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination) {
        graph.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
    }

    // Perform DFS
    public void dfs(int node) {
        visited.add(node);
        ancestors.add(node);

        // Explore neighbors
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor);
            } else if (ancestors.contains(neighbor)) {
                backedges.add(new int[]{node, neighbor});
            }
        }

        // backtrack: remove the ancestors
        ancestors.remove(node);
    }

    // Print the DFS tree and back edges
    public void printBackEdges() {
        System.out.println("Back edges:");
        for (int[] edge : backedges) {
            System.out.println(edge[0] + " -> " + edge[1]);
        }
    }

    public static void main(String[] args) {
        DFSTreeWithBackedge dfsTree = new DFSTreeWithBackedge();

        // Example graph with back edges
        dfsTree.addEdge(0, 1);
        dfsTree.addEdge(1, 2);
        dfsTree.addEdge(2, 0); // Back edge
        dfsTree.addEdge(2, 3);
        dfsTree.addEdge(3, 4);
        dfsTree.addEdge(4, 1); // Back edge

        // Perform DFS from each node (to ensure we cover disconnected components)
        for (int node : dfsTree.graph.keySet()) {
            if (!dfsTree.visited.contains(node)) {
                dfsTree.dfs(node);
            }
        }

        // Print the back edges
        dfsTree.printBackEdges();
    }
}
