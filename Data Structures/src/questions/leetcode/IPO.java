package questions.leetcode;

import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        int currentCapital = w;

        PriorityQueue<int[]> capitalMinHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i=0; i<n; i++) {
            capitalMinHeap.offer(new int[]{capital[i], i});
        }

        PriorityQueue<int[]> profitsMaxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int i=0;
        while (i < k) {
            while (!capitalMinHeap.isEmpty() && capitalMinHeap.peek()[0] <= currentCapital) {
                int[] j = capitalMinHeap.poll();
                profitsMaxHeap.offer(new int[]{profits[j[1]]});
            }

            if (profitsMaxHeap.isEmpty()) {
                break;
            }

            int x = profitsMaxHeap.poll()[0];
            currentCapital += x;
            i++;
        }
        return currentCapital;

    }
}
