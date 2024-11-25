package algorithms.Graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetection {

    static class Vertex {
        public String name;
        public boolean visited;
        public boolean isBeingVisited;
        public List<Vertex> neighbors;

        public Vertex(String name) {
            this.name = name;
            neighbors = new ArrayList<>();
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public void detectCycle(List<Vertex> graph) {
        // there are multiple independent clusters
        for (Vertex vertex : graph) {
            if (!vertex.visited) {
                dfs(vertex);
            }
        }
    }

    private void dfs(Vertex vertex) {
        vertex.isBeingVisited = true;
        // consider the neighbors
        for (Vertex neighbor : vertex.neighbors) {
            if (neighbor.isBeingVisited) {
                System.out.println("Cycle detected - Backward edge!");
                return;
            }

            if (!neighbor.visited) {
                neighbor.visited = true;
                dfs(neighbor);
            }
        }
        vertex.isBeingVisited = false;
        vertex.visited = true;
    }

    public static void main(String[] args) {
        Vertex v0 = new Vertex("A");
        Vertex v1 = new Vertex("B");
        Vertex v2 = new Vertex("C");
        Vertex v3 = new Vertex("D");
        Vertex v4 = new Vertex("E");
        Vertex v5 = new Vertex("F");

        v5.neighbors.add(v0);
        v0.neighbors.add(v4);
        v0.neighbors.add(v2);
        v4.neighbors.add(v5);
        v2.neighbors.add(v1);
        v2.neighbors.add(v3);

        List<Vertex> graph = new ArrayList<>();
        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);

        CycleDetection detection = new CycleDetection();
        detection.detectCycle(graph);
    }
}
