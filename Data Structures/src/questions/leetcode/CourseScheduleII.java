package questions.leetcode;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> order = new ArrayList<>();
        HashMap<Integer, Integer> inDegrees = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i=0; i<numCourses; i++) {
            inDegrees.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        for (int i=0; i<prerequisites.length; i++) {
            int child = prerequisites[i][0];
            int parent = prerequisites[i][1];
            graph.get(parent).add(child);
            inDegrees.put(child, inDegrees.get(child) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entrySet: inDegrees.entrySet()) {
            if (entrySet.getValue() == 0) {
                queue.add(entrySet.getKey());
            }
        }

        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            order.add(vertex);
            List<Integer> children = graph.get(vertex);
            for (int child: children) {
                inDegrees.put(child, inDegrees.get(child) - 1);
                if (inDegrees.get(child) == 0) {
                    queue.add(child);
                }
            }
        }

        if (order.size() != numCourses) {
            return new int[]{};
        }

        int[] n = new int[ numCourses];
        for (int i=0; i<order.size(); i++) {
            n[i] = order.get(i);
        }
        return n;
    }
}
