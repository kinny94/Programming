package practice.Nov28;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalOrderingShortestPath {

    static class Edge {
        public Vertex targetVertex;
        public int weight;

        public Edge(Vertex target, int weight) {
            this.targetVertex = target;
            this.weight = weight;
        }
    }

    static class Vertex {
        public String name;
        public boolean isVisited;
        public int minDistance;
        public Vertex predecessor;
        public List<Edge> neighbors;
        
        public Vertex(String name) {
            this.minDistance = Integer.MAX_VALUE;
            this.name = name;
            this.neighbors = new ArrayList<>();
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    private Stack<Vertex> stack;
    private List<Vertex> graph;

    public TopologicalOrderingShortestPath(List<Vertex> graph) {
        this.stack = new Stack<>();
        this.graph = graph;
        graph.get(0).minDistance = 0;
    }

    public Stack<Vertex> topologicalOrder(List<Vertex> graph) {
        for (Vertex v: graph) {
            if (!v.isVisited) {
                dfs(v);
            }
        }
        return this.stack;
    }

    public void dfs(Vertex vertex) {
        vertex.isVisited = true;
        for (Edge edge: vertex.neighbors) {
            if (!edge.targetVertex.isVisited) {
                dfs(edge.targetVertex);
            }
        }
        stack.push(vertex);
    }

    public void compute() {
        Stack<Vertex> topologicalOrderingStack = topologicalOrder(graph);
        while (!topologicalOrderingStack.isEmpty()) {
            Vertex vertex = topologicalOrderingStack.pop();
            for (Edge edge : vertex.neighbors) {
                Vertex u = edge.targetVertex;
                if (u.minDistance > vertex.minDistance + edge.weight) {
                    u.minDistance = vertex.minDistance + edge.weight;
                    u.predecessor = vertex;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Vertex> graph = new ArrayList<>();
        Vertex v0 = new Vertex("S");
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        v0.neighbors.add(new Edge(v1, 1));
        v0.neighbors.add(new Edge(v3, 2));

        v1.neighbors.add(new Edge(v2, 6));

        v2.neighbors.add(new Edge(v4, 1));
        v2.neighbors.add(new Edge(v5, 2));

        v3.neighbors.add(new Edge(v1, 4));
        v3.neighbors.add(new Edge(v4, 3));

        v4.neighbors.add(new Edge(v5, 1));

        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);

        TopologicalOrderingShortestPath solution = new TopologicalOrderingShortestPath(graph);
        solution.compute();

        for (Vertex v: graph) {
            System.out.println("Distance from s: " +  v.minDistance + " - " + v.predecessor);
        }
    }

}
