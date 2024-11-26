package algorithms.Graph.MinimumSpanningTrees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {

    static class Edge {
        public int destination;
        public int weight;
        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public int primsMst(List<List<Edge>> graph, int numberOfVertices) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        boolean[] visited = new boolean[numberOfVertices];
        int mstWeight = 0;
        pq.add(new Edge(0, 0)); // start from the node 0 with 0 weight

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int node = edge.destination;
            if (!visited[node]) {
                visited[node] = true;
                mstWeight += edge.weight;
                for (Edge neighbor : graph.get(node)) {
                    if (!visited[neighbor.destination]) {
                        pq.add(neighbor);
                    }
                }
            }
        }
        return mstWeight;
    }

    public static void main(String[] args) {
        int vertices = 5; // Number of vertices in the graph

        // Adjacency list representation of the graph
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding edges to the graph (undirected graph)
        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(3, 6));
        graph.get(1).add(new Edge(0, 2));
        graph.get(1).add(new Edge(2, 3));
        graph.get(1).add(new Edge(3, 8));
        graph.get(1).add(new Edge(4, 5));
        graph.get(2).add(new Edge(1, 3));
        graph.get(2).add(new Edge(4, 7));
        graph.get(3).add(new Edge(0, 6));
        graph.get(3).add(new Edge(1, 8));
        graph.get(4).add(new Edge(1, 5));
        graph.get(4).add(new Edge(2, 7));

        // Find the MST weight using Prim's Algorithm
        PrimsAlgo primsAlgo = new PrimsAlgo();
        int mstWeight = primsAlgo.primsMst(graph, vertices);
        System.out.println("Total weight of MST: " + mstWeight);
    }
}
