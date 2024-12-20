package questions.leetcode;

import java.util.*;

public class CompilationOrder {
    public static List<Character> findCompilationOrder(ArrayList<ArrayList<Character>> dependencies) {
        List<Character> sortedOrder = new ArrayList<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegrees = new HashMap<>();

        for (int i=0; i<dependencies.size(); i++) {
            char parent = dependencies.get(i).get(1);
            char child = dependencies.get(i).get(0);
            graph.put(parent, new ArrayList<>());
            graph.put(child, new ArrayList<>());
            inDegrees.put(parent, 0);
            inDegrees.put(child, 0);
        }

        if (graph.size() <= 0) {
            return sortedOrder;
        }

        for (int i=0; i<dependencies.size(); i++) {
            char parent = dependencies.get(i).get(1);
            char child = dependencies.get(i).get(0);
            graph.get(parent).add(child);
            inDegrees.put(child, inDegrees.get(child) + 1);
            System.out.println("\t\t\tDependency pair: " + dependencies.get(i) + " ⟶ parent: " + parent + ", child: " + child);
            System.out.println("\t\t\tAppending the child to the parent's list in the graph:");
            System.out.println("\t\t\t\tGraph: " + graph);
            System.out.println("\t\t\tIncrementing indegree of the child ⟶ " + inDegrees);
        }


        Queue<Character> sources = new LinkedList<>();
        for (char key: inDegrees.keySet()) {
            if (inDegrees.get(key) == 0) {
                sources.add(key);
            }
        }

        while(!sources.isEmpty()) {
            char vertex = sources.poll();
            sortedOrder.add(vertex);
            for (int i=0; i<graph.get(vertex).size(); i++) {
                inDegrees.put(graph.get(vertex).get(i), inDegrees.get(graph.get(vertex).get(i)) - 1);
                if (inDegrees.get(graph.get(vertex).get(i)) == 0) {
                    sources.add(graph.get(vertex).get(i));
                }
            }
        }

        if (sortedOrder.size() != graph.size()) {
            return new ArrayList<>();
        }
        return sortedOrder;
    }
}
