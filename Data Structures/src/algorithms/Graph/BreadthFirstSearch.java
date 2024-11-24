package algorithms.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Vertex {

    public String name;
    public boolean visited;
    public List<Vertex> adjacentLists;

    public Vertex(String name) {
        this.name = name;
        this.adjacentLists = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class BreadthFirstSearch {

    public void traverse(Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();
        root.visited = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            Vertex current = queue.remove();
            System.out.println("Actual visited: " + current.name);
            for (Vertex neighbor : current.adjacentLists) {
                if (!neighbor.visited) {
                    neighbor.visited = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        a.adjacentLists.add(b);
        a.adjacentLists.add(f);
        a.adjacentLists.add(g);

        b.adjacentLists.add(a);
        b.adjacentLists.add(c);
        b.adjacentLists.add(d);

        c.adjacentLists.add(b);

        d.adjacentLists.add(b);
        d.adjacentLists.add(e);

        f.adjacentLists.add(a);

        g.adjacentLists.add(a);
        g.adjacentLists.add(h);

        h.adjacentLists.add(g);

        bfs.traverse(a);


    }
}
