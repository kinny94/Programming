import java.util.*;

class Vertex {

    private String data;
    private boolean visited;
    private List<Vertex> neighborList;

    public Vertex(String data) {
        this.data = data;
        this.neighborList = new ArrayList<Vertex>();
    }

    public void addNeighbor(Vertex vertex) {
        this.neighborList.add(vertex);
    }

    @Override
    public String toString() {
        return this.data;
    }


    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
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
}

class TopologicalOrdering {

    private Stack<Vertex> stack;

    TopologicalOrdering() {
        this.stack = new Stack<Vertex>();
    }

    public void dfs(Vertex vertex) {
        vertex.setVisited(true);

        for (Vertex v: vertex.getNeighborList()) {
            if (!v.isVisited()) {
                dfs(v);
            }
        }

        stack.push(vertex);
    }

    public Stack<Vertex> getStack() {
        return this.stack;
    }

    public static void main(String[] args) {
        TopologicalOrdering topologicalOrdering = new TopologicalOrdering();
        List<Vertex> graph = new ArrayList<Vertex>();
        graph.add(new Vertex("0"));
        graph.add(new Vertex("1"));
        graph.add(new Vertex("2"));
        graph.add(new Vertex("3"));
        graph.add(new Vertex("4"));
        graph.add(new Vertex("5"));

        graph.get(2).addNeighbor(graph.get(3));
        graph.get(3).addNeighbor(graph.get(1));
        graph.get(4).addNeighbor(graph.get(0));
        graph.get(4).addNeighbor(graph.get(1));
        graph.get(5).addNeighbor(graph.get(0));
        graph.get(5).addNeighbor(graph.get(2));

        for (int i=0; i<graph.size(); ++i) {
            if (!graph.get(i).isVisited()) {
                topologicalOrdering.dfs(graph.get(i));
            }
        }

        Stack<Vertex> stack = topologicalOrdering.getStack();

        for(int i=0; i<graph.size(); ++i) {
            Vertex vertex = stack.pop();
            System.out.println(vertex + "-> ");
        }
    }
}