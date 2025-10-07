package practice.Nov28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    
    static class Edge {
        public int node;
        public int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void dijktraAlgo(List<List<Edge>> graph, int source) {
        int numberOfNodes = graph.size();
        int[] distances = new int[numberOfNodes];
        boolean[] visites = new boolean[numberOfNodes];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(source, 0));

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int currentNode = edge.node;
            if (visites[currentNode]) {
                continue;
            }
            visites[currentNode] = true;
            for (Edge neighbor: graph.get(currentNode)) {
                if (distances[neighbor.node] > distances[currentNode] + neighbor.weight) {
                    distances[neighbor.node] = distances[currentNode] + neighbor.weight;
                    pq.add(new Edge(neighbor.node, neighbor.weight));
                }
            }
        }

        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < numberOfNodes; i++) {
            System.out.println("Node " + i + " -> " + distances[i]);
        }
    }

    public static void main(String[] args) {
        int numberOfNodes = 5;

        // Graph represented as adjacency list
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < numberOfNodes; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (source, destination, weight)
        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(2, 4));
        graph.get(1).add(new Edge(2, 1));
        graph.get(1).add(new Edge(3, 7));
        graph.get(2).add(new Edge(4, 3));
        graph.get(3).add(new Edge(4, 1));

        // Run Dijkstra's algorithm
        Dijkstra.dijktraAlgo(graph, 0);
    }
}
