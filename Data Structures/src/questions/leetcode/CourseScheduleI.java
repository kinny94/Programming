package questions.leetcode;

import java.util.*;

public class CourseScheduleI {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> order = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (int i=0; i<numCourses; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }

        for (int i=0; i<prerequisites.length; i++) {
            int child = prerequisites[i][0];
            int parent = prerequisites[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            order.add(vertex);
            List<Integer> children = graph.get(vertex);
            for (int child: children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    queue.add(child);
                }
            }
        }

        System.out.println(order);
        if (order.size() != numCourses) {
            return false;
        }
        return true;
    }
}
