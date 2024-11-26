package algorithms.Graph.ShortestPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TopologicalOrdering {

    static class Vertex {
        public String name;
        public boolean isVisited;
        public List<Vertex> neighbors;

        public Vertex(String name) {
            this.name = name;
            this.neighbors = new ArrayList<>();
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    private Stack<Vertex> stack;

    public TopologicalOrdering() {
        this.stack = new Stack<>();
    }

    public void dfs(Vertex vertex) {
        vertex.isVisited = true;
        for (Vertex v: vertex.neighbors) {
            if (!v.isVisited) {
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
        List<Vertex> graph = new ArrayList<>();
        graph.add(new Vertex("0"));
        graph.add(new Vertex("1"));
        graph.add(new Vertex("2"));
        graph.add(new Vertex("3"));
        graph.add(new Vertex("4"));
        graph.add(new Vertex("5"));

        graph.get(2).neighbors.add(graph.get(3));
        graph.get(3).neighbors.add(graph.get(1));
        graph.get(4).neighbors.add(graph.get(0));
        graph.get(4).neighbors.add(graph.get(1));
        graph.get(5).neighbors.add(graph.get(0));
        graph.get(5).neighbors.add(graph.get(2));

        // consider all vertex because we are dealing witth directed graphs
        for (int i=0; i<graph.size(); i++) {
            if (!graph.get(i).isVisited) {
                topologicalOrdering.dfs(graph.get(i));
            }
        }

        Stack<Vertex> stack1 = topologicalOrdering.getStack();
        for (int i=0; i<graph.size(); i++) {
            System.out.println(stack1.pop());
        }
    }
}
