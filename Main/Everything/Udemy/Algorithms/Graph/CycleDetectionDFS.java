import java.util.*;

class Vertex {

    private String name;
    private boolean isVisited;
    private boolean isBeingVisited;
    private List<Vertex> adjacenciesList;

    Vertex(String name) {
        this.name = name;
        this.adjacenciesList = new ArrayList<Vertex>();
    }

    @Override
    public String toString() {
        return "" + name;
    }

    public void addNeighbor(Vertex vertex) {
        this.adjacenciesList.add(vertex);
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
    
    public void setIsBeingVisited(boolean isBeingVisited) {
        this.isBeingVisited = isBeingVisited;
    }

    public boolean getIsBeingVisited() {
        return this.isBeingVisited;
    }

    public List<Vertex> getAdjacenciesList() {
        return this.adjacenciesList;
    }
}

class CycleDetectionDFS {

    public void detectCycle(List<Vertex> vertexList) {
        for(Vertex v: vertexList) {
            if (!v.getIsVisited()) {
                dfs(v);
            }
        }
    }

    public void dfs(Vertex vertex) {

        System.out.println("DFS on vertex: " + vertex);
        vertex.setIsBeingVisited(true);
        for (Vertex v: vertex.getAdjacenciesList()) {

            System.out.println("Visiting the neighbor of vertex: " + vertex);
            if (v.getIsBeingVisited()) {
                System.out.println("There is a backward edge: So there is a cycle");
                return;
            }

            if (!v.getIsVisited()) {
                System.out.println("Visiting vertex " + v + " recurrsively");
                v.setIsVisited(true);
                dfs(v);
            }
        }

        System.out.println("Set vertex " + vertex + " setBeingVisited(false) and visited(true)");
        vertex.setIsBeingVisited(false);
        vertex.setIsVisited(true);
    }

    public static void main(String[] args) {

        Vertex vertex1 = new Vertex("1");
        Vertex vertex2 = new Vertex("2");
        Vertex vertex3 = new Vertex("3");
        Vertex vertex4 = new Vertex("4");
        Vertex vertex5 = new Vertex("5");
        Vertex vertex6 = new Vertex("6");

        vertex1.addNeighbor(vertex2);
        vertex1.addNeighbor(vertex3);
        vertex2.addNeighbor(vertex3);
        vertex4.addNeighbor(vertex1);
        vertex4.addNeighbor(vertex5);
        vertex5.addNeighbor(vertex6);
        vertex6.addNeighbor(vertex5);

        List<Vertex> vertexList = new ArrayList<Vertex>();
        vertexList.add(vertex1);
        vertexList.add(vertex2);
        vertexList.add(vertex3);
        vertexList.add(vertex4);
        vertexList.add(vertex5);
        vertexList.add(vertex6);

        CycleDetectionDFS cycleDetection = new CycleDetectionDFS();
        cycleDetection.detectCycle(vertexList);
    }
}