package algorithms.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    static class Vertex {
        public String name;
        public boolean visited;
        public List<Vertex> neighbors;

        public Vertex(String name) {
            this.name = name;
            this.neighbors = new ArrayList<Vertex>();
        }

        @Override
        public String toString() {
            return name;
         }
    }

    private Stack<Vertex> stack;

    public DepthFirstSearch() {
        stack = new Stack<>();
    }

    public void dfs(List<Vertex> vertexList) {
        for (Vertex vertex : vertexList) {
            if (!vertex.visited) {
                vertex.visited = true;
                stack.add(vertex);
                while (!stack.isEmpty()) {
                    Vertex current = stack.pop();
                    System.out.println(current);
                    for (Vertex neighbor : current.neighbors) {
                        if (!neighbor.visited) {
                            neighbor.visited = true;
                            stack.push(neighbor);
                        }
                    }
                }
            }
        }
    }

    public void dfsRecursion(List<Vertex> vertexList) {
        for (Vertex vertex : vertexList) {
            if (!vertex.visited) {
                vertex.visited = true;
                dfsHelper(vertex);
            }
        }
    }

    private void dfsHelper(Vertex vertex) {
        System.out.println(vertex);
        for (Vertex neighbor : vertex.neighbors) {
            if (!neighbor.visited) {
                neighbor.visited = true;
                dfsHelper(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        List<Vertex> list = new ArrayList<>();
        v1.neighbors.add(v2);
        v1.neighbors.add(v3);
        v3.neighbors.add(v4);
        v4.neighbors.add(v5);
        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.dfs(list);
        System.out.println("************");

        List<Vertex> list2 = new ArrayList<>();
        Vertex x1 = new Vertex("A");
        Vertex x2 = new Vertex("B");
        Vertex x3 = new Vertex("C");
        Vertex x4 = new Vertex("D");
        Vertex x5 = new Vertex("E");
        Vertex x6 = new Vertex("F");
        Vertex x7 = new Vertex("G");
        Vertex x8 = new Vertex("H");

        x1.neighbors.add(x2);
        x1.neighbors.add(x6);
        x1.neighbors.add(x7);
        x2.neighbors.add(x3);
        x2.neighbors.add(x4);
        x4.neighbors.add(x5);
        x7.neighbors.add(x8);

        list2.add(x1);
        list2.add(x2);
        list2.add(x3);
        list2.add(x4);
        list2.add(x5);
        list2.add(x6);
        list2.add(x7);

        dfs.dfsRecursion(list2);
    }
}
