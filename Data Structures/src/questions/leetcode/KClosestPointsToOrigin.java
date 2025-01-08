package questions.leetcode;

import java.util.*;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {

//        Queue<int[]> queue = new PriorityQueue<int[]>((a, b) -> b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1]);
//
//        for (int i = 0; i < points.length; i++) {
//            queue.add(new int[]{points[i][0], points[i][1]});
//
//            if (queue.size() > k) {
//                queue.poll();
//            }
//        }
//
//        int[][] answer = new int[k][2];
//
//        for (int i = 0; i < k; i++) {
//            answer[i] = queue.poll();
//        }
//
//        return answer;

        List<Pair<Integer, int[]>> list = new ArrayList<>();

        // Compute distances and store them as pairs
        for (int[] point : points) {
            int distance = point[0] * point[0] + point[1] * point[1];
            list.add(new Pair<>(distance, point));
        }

        // Use the quickSelect method to find the k closest points
        quickSelect(list, k);

        // Collect the k closest points
        List<int[]> answer = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            answer.add(list.get(i).getValue());
        }

        return answer.toArray(new int[k][]);
    }

    public void quickSelect(List<Pair<Integer, int[]>> list, int k) {
        if (list.size() <= 1) {
            return;
        }

        List<Pair<Integer, int[]>> left = new ArrayList<>();
        List<Pair<Integer, int[]>> right = new ArrayList<>();
        List<Pair<Integer, int[]>> mid = new ArrayList<>();

        int pivotIndex = new Random().nextInt(list.size());
        int pivot = list.get(pivotIndex).getKey();

        for (Pair<Integer, int[]> pair: list) {
            if (pair.getKey() < pivot) {
                left.add(pair);
            } else if (pair.getKey() > pivot) {
                right.add(pair);
            } else {
                mid.add(pair);
            }
        }

        if (k <= left.size()) {
            quickSelect(left, k);
            list.clear();
            list.addAll(left);
        } else if (k > left.size() + mid.size()) {
            quickSelect(right, k - left.size() - mid.size());
            list.clear();
            list.addAll(left);
            list.addAll(mid);
            list.addAll(right);
        } else {
            list.clear();
            list.addAll(left);
            list.addAll(mid);
        }
    }
}
