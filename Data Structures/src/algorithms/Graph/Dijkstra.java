package algorithms.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    static class Vertex implements Comparable<Vertex> {
        public String name;
        public boolean visited;
        public List<Edge> neighbors;
        // distance from the starting vertex (source)
        public double distance;
        // previous vertex on the shortest path
        public Vertex predecessor;

        public Vertex(String name) {
            this.name = name;
            this.neighbors = new ArrayList<Edge>();
            this.distance = Double.MAX_VALUE; // It the beginning every item is infinite value away from each other
        }

        @Override
        public String toString() {
            return name + " - " + distance;
        }

        @Override
        public int compareTo(Vertex o) {
            return Double.compare(this.distance, o.distance);
        }
    }

    static class Edge {
        public double weight;
        public Vertex startVertex;
        public Vertex targetVertex;

        public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
            this.weight = weight;
            this.startVertex = startVertex;
            this.targetVertex = targetVertex;
        }
    }

    public void computePath(Vertex source) {
        source.distance = 0; // starting distance will be 0
        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
        pq.add(source);
        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();
            for (Edge edge: currentVertex.neighbors) {
                Vertex u = edge.startVertex;
                Vertex v = edge.targetVertex;

                double newDistance = currentVertex.distance + edge.weight;
                if (newDistance < v.distance) {
                    // there is a shorter path to vertex v
                    pq.remove(v);
                    v.distance = newDistance;
                    v.predecessor = currentVertex;
                    pq.add(v);
                }
            }
        }
    }

    public List<Vertex> getShortestPath(Vertex targetVertex) {
        List<Vertex> path = new ArrayList<>();
        for (Vertex v=targetVertex; v!=null; v=v.predecessor) {
            path.add(v);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Vertex v0 = new Vertex("A");
        Vertex v1 = new Vertex("B");
        Vertex v2 = new Vertex("C");
        Vertex v3 = new Vertex("D");
        Vertex v4 = new Vertex("E");
        Vertex v5 = new Vertex("F");
        Vertex v6 = new Vertex("G");
        Vertex v7 = new Vertex("H");

        v0.neighbors.add(new Edge(5, v0, v1));
        v0.neighbors.add(new Edge(9, v0, v4));
        v0.neighbors.add(new Edge(8, v0, v7));

        v1.neighbors.add(new Edge(12, v1, v2));
        v1.neighbors.add(new Edge(15, v1, v3));
        v1.neighbors.add(new Edge(4, v1, v7));

        v2.neighbors.add(new Edge(3, v2, v3));
        v2.neighbors.add(new Edge(11, v2, v6));

        v3.neighbors.add(new Edge(9, v3, v6));

        v4.neighbors.add(new Edge(4, v4, v5));
        v4.neighbors.add(new Edge(20, v4, v6));
        v4.neighbors.add(new Edge(5, v4, v7));

        v5.neighbors.add(new Edge(1, v5, v2));
        v5.neighbors.add(new Edge(13 , v5, v7));

        v7.neighbors.add(new Edge(7, v7, v2));
        v7.neighbors.add(new Edge(16, v7, v5));

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.computePath(v0);
        System.out.println(dijkstra.getShortestPath(v6));
    }
}
