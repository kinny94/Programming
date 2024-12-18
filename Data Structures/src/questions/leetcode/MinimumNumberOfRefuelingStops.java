package questions.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }

        int i = 0;
        int stops = 0;
        int maxDistance = startFuel;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        while (maxDistance < target) {
            if (i < stations.length && stations[i][0] <= maxDistance) {
                maxHeap.add(stations[i][1]);
                i++;
            } else if (maxHeap.isEmpty()) {
                return -1;
            } else {
                maxDistance = maxDistance + maxHeap.poll();
                stops++;
            }
        }
        return stops;
    }
}
