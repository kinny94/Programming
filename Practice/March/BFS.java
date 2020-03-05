import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

class Vertex {
    private int data;
    private boolean visited;
    private List<Vertex> neighborsList;

    public Vertex(int data) { 
        this.data = data;
        this.neighborsList = new ArrayList<>();
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean getVisited() {
        return this.visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    } 

    public List<Vertex> getNeighborList() {
        return this.neighborsList;
    }

    public void setNeightborList(List<Vertex> neighborsList) {
        this.neighborsList = neighborsList;
    } 

    public void addNeighborVertex(Vertex vertex) {
        this.neighborsList.add(vertex);
    }

    @Override
    public String toString() {
        return ""+this.data;
    }
}

class BFS {

    public void breadthFirstSearch(Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();
        root.setVisited(true);
        queue.add(root);

        while(!queue.isEmpty()) {
            Vertex actualVertex = queue.remove();
            System.out.println(actualVertex + " ");

            for (Vertex v: actualVertex.getNeighborList()) {
                if (!v.getVisited()) {
                    v.setVisited(true);
                    queue.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);

        vertex1.addNeighborVertex(vertex2);
        vertex1.addNeighborVertex(vertex4);

        vertex4.addNeighborVertex(vertex5);
        vertex2.addNeighborVertex(vertex3);

        bfs.breadthFirstSearch(vertex1);

    }
}