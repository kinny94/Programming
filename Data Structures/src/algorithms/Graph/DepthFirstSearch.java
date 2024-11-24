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
//        System.out.println(list);
        System.out.println("**********");
        dfs.dfsRecursion(list);
    }
}
