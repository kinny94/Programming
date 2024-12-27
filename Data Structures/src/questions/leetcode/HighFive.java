package questions.leetcode;

import java.util.*;

public class HighFive {
    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxId = 0;

        for (int[] item: items) {
            int id = item[0];
            int score = item[1];
            map.putIfAbsent(id, new ArrayList<>());
            map.get(id).add(score);
            maxId = Math.max(maxId, id);
        }

        List<int[]> resultList = new ArrayList<>();
        for (int i=1; i<=maxId; i++) {
            if (map.containsKey(i)) {
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                pq.addAll(map.get(i));
                int sum = 0;
                for (int j=0; j<5 && !pq.isEmpty(); j++) {
                    sum += pq.poll();
                }
                int average = sum / 5;
                resultList.add(new int[]{i, average});
            }
        }

        int[][] result = new int[resultList.size()][2];
        for (int i=0; i<resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
