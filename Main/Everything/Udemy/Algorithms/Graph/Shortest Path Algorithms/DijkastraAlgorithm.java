import java.util.Collections;
import java.util.*;
import java.util.PriorityQueue;

class Vertex implements Comparable<Vertex> {

    private String name;
    private List<Edge> adjacenciesList; // every edge is pointing to a neighbor 
    private boolean isVisited;
    private Vertex predecessor; // from what vertex we came to this one
    private double distance = Double.MAX_VALUE; // we initialize it to infinity

    public Vertex(String name) {
        this.name = name;
        this.adjacenciesList = new ArrayList<Edge>(); 
    }

    public void addNeighbor(Edge edge) {
        this.adjacenciesList.add(edge);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public boolean getIsVisited() {
        return this.isVisited;
    }

    public void setPredecessor(Vertex vertex) {
        this.predecessor = vertex;
    }

    public Vertex getPredecessor() {
        return this.predecessor;
    }

    public void setdistance(double distance) {
        this.distance = distance;
    }

    public double getdistance() {
        return this.distance;
    }

    public void setAdjacencies(List<Edge> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }

    public List<Edge> getAdjacenciesList() {
        return this.adjacenciesList;
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.distance, otherVertex.getdistance());
    }

}

class Edge {
    private double weight;
    private Vertex startVertex;
    private Vertex targetVertex;

    public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getStarVertex() {
        return this.startVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }

    public Vertex getTargetVertex() {
        return this.targetVertex;
    }
}

class DijkastraAlgorithm {
    
    public void computerPath(Vertex sourceVertex) {
        sourceVertex.setdistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<Vertex>();
        priorityQueue.add(sourceVertex);

        while(!priorityQueue.isEmpty()) {
            Vertex actualVertex = priorityQueue.poll(); // removes the head of the queue - i.e vertex with minimum distance - coz of comparable interface.. minimum distance one will be the root for the min heap
            for (Edge edge: actualVertex.getAdjacenciesList()) {
                Vertex v = edge.getTargetVertex();
                double newDistance = actualVertex.getdistance() + edge.getWeight();
                if (newDistance < v.getdistance())  {
                    priorityQueue.remove(v);
                    v.setdistance(newDistance);
                    v.setPredecessor(actualVertex);
                    priorityQueue.add(v);
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex targetVertex) {
        List<Vertex> shortestPathToTarget = new ArrayList<Vertex>();
        for (Vertex vertex = targetVertex; vertex!=null; vertex=vertex.getPredecessor()) {
            shortestPathToTarget.add(vertex);
        }

        Collections.reverse(shortestPathToTarget);
        return shortestPathToTarget;
    }

    public static void main(String[] args) {
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");

        vertex1.addNeighbor(new Edge(1, vertex1, vertex2));
        vertex1.addNeighbor(new Edge(3, vertex1, vertex3));
        vertex2.addNeighbor(new Edge(1, vertex2, vertex3));

        DijkastraAlgorithm djks = new DijkastraAlgorithm();
        djks.computerPath(vertex1);
        System.out.println(djks.getShortestPathTo(vertex3));
    }
}