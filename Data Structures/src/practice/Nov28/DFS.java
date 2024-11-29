package practice.Nov28;

import java.util.ArrayList;
import java.util.List;

public class DFS {
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

    public void dfs(List<Vertex> vertexList) {
        for (Vertex vertex: vertexList) {
            if (!vertex.visited) {
                vertex.visited = true;
                dfsHelper(vertex);
            }
        }
    }

    private void dfsHelper(Vertex vertex) {
        System.out.println(vertex);
        for (Vertex neighbor: vertex.neighbors) {
            if (!neighbor.visited) {
                neighbor.visited = true;
                dfsHelper(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        
        DFS dfs = new DFS();
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

        dfs.dfs(list2);
    }
}
