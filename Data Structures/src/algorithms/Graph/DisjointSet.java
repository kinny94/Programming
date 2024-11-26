package algorithms.Graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    public List<Integer> parent;
    public List<Integer> rank;

    public DisjointSet(int size) {
        parent = new ArrayList<>();
        rank = new ArrayList<>();

        // Initialize each element as its own parent and rank as 0
        for (int i = 0; i < size; i++) {
            parent.add(i);
            rank.add(0);
        }
    }

    // Find with path compression
    public int find(int x) {
        if (parent.get(x) != x) {
            parent.set(x, find(parent.get(x))); // Path compression
        }
        return parent.get(x);
    }

    // Find with Path Compression
    public int findWithPathCompression(int x) {
        if (parent.get(x) != x) {
            parent.set(x, findWithPathCompression(parent.get(x))); // Path compression
        }
        return parent.get(x);
    }

    // Union without rank
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent.set(rootX, rootY);
            return true;
        }
        System.out.println("Cycle detected!");
        return false;
    }

    // Union with rank
    public boolean unionByRank(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank.get(rootX) > rank.get(rootY)) {
                parent.set(rootY, rootX);
            } else if (rank.get(rootX) < rank.get(rootY)) {
                parent.set(rootX, rootY);
            } else {
                parent.set(rootY, rootX);
                rank.set(rootX, rank.get(rootX) + 1);
            }
            System.out.println("Union complete");
            return true;
        }
        // Cycle detected
        return false;
    }

    public boolean hasCycle(int[][] graph) {
        boolean hasCycle = false;
        for (int[] edge : graph) {
            int u = edge[0];
            int v = edge[1];

            if (!union(u, v)) {
                hasCycle = true;
                break;
            }
        }

        System.out.println("Graph contains cycle: " + hasCycle);
        return hasCycle;
    }

    public static void main(String[] args) {
//        int numberOfNodes = 5;
//        DisjointSet ds = new DisjointSet(numberOfNodes);
//
//        // Example edges in the graph
//        int[][] edges = {
//                {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 1}
//        };
//
//        // Uncomment one of the following to test:
//        // ds.hasCycle(edges);
//        ds.unionByRank(edges[1][0], edges[2][0]);

        int testNodes = 10000; // Large test case
        DisjointSet ds = new DisjointSet(testNodes);

        // Perform unions to create some connected components
        for (int i = 1; i < testNodes; i++) {
            ds.union(i - 1, i);
        }

        // Test find without path compression
        System.out.println("Find without path compression:");
        long startTime = System.nanoTime();
        for (int i = 0; i < testNodes; i++) {
            ds.find(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken (find): " + (endTime - startTime) + " ns");

        // Test find with path compression
        System.out.println("Find with path compression:");
        startTime = System.nanoTime();
        for (int i = 0; i < testNodes; i++) {
            ds.findWithPathCompression(i);
        }
        endTime = System.nanoTime();
        System.out.println("Time taken (findWithPathCompression): " + (endTime - startTime) + " ns");

        // Verify the structure
        System.out.println("Parent of 0: " + ds.findWithPathCompression(0));
        System.out.println("Parent of last element: " + ds.findWithPathCompression(testNodes - 1));
    }
}
