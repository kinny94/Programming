package questions.leetcode;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] time: times) {
            int source = time[0];
            int destination = time[1];
            int travelTime = time[2];

            if (!adjList.containsKey(source)) {
                adjList.put(source, new ArrayList<>());
            }
            adjList.get(source).add(new int[]{destination, travelTime});
        }


        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, k});
        Set<Integer> visited = new HashSet<>();
        int delays = 0;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentNode = current[1];
            int currentTime = current[0];

            if (visited.contains(currentNode)) {
                continue;
            }

            visited.add(currentNode);
            delays = Math.max(delays, currentTime);
            List<int[]> children = adjList.getOrDefault(currentNode, new ArrayList<>());
            for (int[] child: children) {
                int neighborNode = child[0];
                int neighborTime = child[1];
                if (!visited.contains(neighborNode)) {
                    int newTime = currentTime + neighborTime;
                    minHeap.add(new int[]{newTime, neighborNode});
                }
            }
        }
        if (visited.size() == n) {
            return delays;
        }

        return -1;
    }
}
