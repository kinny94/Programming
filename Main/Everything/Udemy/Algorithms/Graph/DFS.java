import java.util.Stack;
import java.util.*;

class Vertex {

    private String name;
    private boolean visited;
    private List<Vertex> neighborList;

    Vertex(String name) {
        this.name = name;
        this.neighborList = new ArrayList<Vertex>();
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return this.visited;
    }


    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighborList() {
        return this.neighborList;
    }

    public void setNeighborList(List<Vertex> list) {
        this.neighborList = list;
    }

    public void addNeighbor(Vertex vertex) {
        this.neighborList.add(vertex);
    }
}

class DFS {

    private Stack<Vertex> stack;

    DFS() {
        this.stack = new Stack<Vertex>();
    }

    public void depthFirstSearch(List<Vertex> vertexList) {

        for(Vertex v: vertexList) {
            if (!v.isVisited()) {
                v.setVisited(true);
                dfsWithStack(v);
                // dfsWithRecurrsion(v);
            }
        }
    }

    public void dfsWithStack(Vertex rootVertex) {
        this.stack.add(rootVertex);
        rootVertex.setVisited(true);

        while(!stack.isEmpty()) {
            Vertex actualVertex = this.stack.pop();
            System.out.println(actualVertex+ " ");

            for(Vertex v : actualVertex.getNeighborList()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    this.stack.push(v);
                }
            }
        }
    }

    private void dfsWithRecurrsion(Vertex v) {
        System.out.println(v + " ");
        for (Vertex vertex: v.getNeighborList()) {
            if (!vertex.isVisited()) {
                vertex.setVisited(true);
                dfsWithRecurrsion(vertex);
            }
        }
    }

    public static void main(String[] args) {

        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");

        List<Vertex> list = new ArrayList<Vertex>();

        v1.addNeighbor(v2);
        v1.addNeighbor(v3);

        v3.addNeighbor(v4);
        v4.addNeighbor(v5);

        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        list.add(v5);

        DFS dfs = new DFS();
        dfs.depthFirstSearch(list);
        System.out.println();
    }
}