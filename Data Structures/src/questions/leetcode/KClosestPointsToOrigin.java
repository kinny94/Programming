package questions.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {

        Queue<int[]> queue = new PriorityQueue<int[]>((a, b) -> b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1]);

        for (int i = 0; i < points.length; i++) {
            queue.add(new int[]{points[i][0], points[i][1]});

            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[][] answer = new int[k][2];

        for (int i = 0; i < k; i++) {
            answer[i] = queue.poll();
        }

        return answer;

    }
}
