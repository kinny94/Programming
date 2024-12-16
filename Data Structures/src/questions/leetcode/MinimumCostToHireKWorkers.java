package questions.leetcode;

import java.util.*;

public class MinimumCostToHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<double[]> workers = new ArrayList<>();
        for (int i=0; i<quality.length; i++) {
            workers.add(new double[]{(double) wage[i] / quality[i], (double) quality[i]});
        }

        Collections.sort(workers, Comparator.comparingDouble(a -> a[0]));

        PriorityQueue<Double> heap = new PriorityQueue<>(Collections.reverseOrder());
        double totalQuality = 0;
        double minCost = Double.MAX_VALUE;

        for (double[] worker: workers) {
            double ratio = worker[0];
            double q = worker[1];
            heap.add(q);
            totalQuality += q;

            if (heap.size() > k) {
                totalQuality -= heap.poll();
            }

            if (heap.size() == k) {
                minCost = Math.min(minCost, ratio * totalQuality);
            }
        }
        return minCost;
    }
}
