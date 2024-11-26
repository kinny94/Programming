package algorithms.Graph.MinimumSpanningTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalAlgo {

    static class DisjointSet {
        List<Integer> parent;
        List<Integer> rank;
        int numberOfVertices;

        public DisjointSet(int numberOfVertices) {
            parent = new ArrayList<>();
            rank = new ArrayList<>();
            this.numberOfVertices = numberOfVertices;
            for (int i = 0; i < numberOfVertices; i++) {
                parent.add(-1);
                rank.add(0); // Initial rank is 0
            }
        }

        // Find with Path Compression
        public int find(int i) {
            if (parent.get(i) == -1) {
                return i;
            }
            parent.set(i, find(parent.get(i))); // Path compression
            return parent.get(i);
        }

        // Union by Rank
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank.get(rootX) < rank.get(rootY)) {
                    parent.set(rootX, rootY);
                } else if (rank.get(rootX) > rank.get(rootY)) {
                    parent.set(rootY, rootX);
                } else {
                    parent.set(rootY, rootX);
                    rank.set(rootX, rank.get(rootX) + 1); // Correct rank update
                }
            }
        }
    }

    static class Edge {
        public int source;
        public int target;
        public int weight;
        public Edge(int source, int target, int weight){
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }

    public int kruskalMST(List<Edge> edges, int numberOfVertices) {
        // Sort edges by weight
        Collections.sort(edges, Comparator.comparingInt(e -> e.weight)); // Stable sort
        DisjointSet ds = new DisjointSet(numberOfVertices);
        int mstWeight = 0;
        List<Edge> mstEdges = new ArrayList<>();

        for (Edge edge : edges) {
            int rootSource = ds.find(edge.source);
            int rootTarget = ds.find(edge.target);

            System.out.println("Processing edge: " + edge.source + " - " + edge.target + " | Weight: " + edge.weight);
            System.out.println("Roots: " + rootSource + ", " + rootTarget);

            if (rootSource != rootTarget) {
                mstEdges.add(edge);
                mstWeight += edge.weight;
                ds.union(edge.source, edge.target);
            }
        }

        System.out.println("Edges in the MST:");
        for (Edge edge : mstEdges) {
            System.out.println("Edge: " + edge.source + " - " + edge.target + " | Weight: " + edge.weight);
        }

        return mstWeight;
    }

    public static void main(String[] args) {
        int numberOfVertices = 5;

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));

        KruskalAlgo kruskalAlgo = new KruskalAlgo();
        System.out.println("Total weight of MST: " + kruskalAlgo.kruskalMST(edges, numberOfVertices));
    }
}
