package questions.leetcode;

import java.util.PriorityQueue;

public class KWeakestRowsInAMatrix {
    private static int binarySearch(int[] row, int n) {
        int low = 0, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        PriorityQueue<int[]> pq = new  PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            else return b[0] - a[0];
        });
        for (int i = 0; i < m; i++) {
            int strength = binarySearch(mat[i], n);
            pq.offer(new int[]{strength, i});
            if (pq.size() > k) pq.poll();
        }

        int[] indexes = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            indexes[i] = pq.poll()[1];
        }

        return indexes;
    }
}
