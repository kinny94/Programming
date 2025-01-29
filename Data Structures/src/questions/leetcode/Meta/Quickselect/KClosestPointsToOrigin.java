package questions.leetcode.Meta.Quickselect;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Pair<K, V> {
    K key;
    V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }
}

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {

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
