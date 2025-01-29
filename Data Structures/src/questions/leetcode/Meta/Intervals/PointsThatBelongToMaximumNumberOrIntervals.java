package questions.leetcode.Meta.Intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PointsThatBelongToMaximumNumberOrIntervals {
    public static void intervalSolution(int[][] intervals) {
        int maxNum = 0;
        int maxFreq = 0;

        // Sort intervals based on the start value of each interval
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap to keep track of the end times of the intervals
        PriorityQueue<Integer> heapArr = new PriorityQueue<>();

        // Process each interval
        for (int[] interval : intervals) {
            // Remove all intervals that end before the current interval's start time
            while (!heapArr.isEmpty() && heapArr.peek() < interval[0]) {
                heapArr.poll();
            }

            // Add the current interval's end time to the heap
            heapArr.add(interval[1]);

            // If the current heap size is greater than maxFreq, update maxFreq and maxNum
            if (heapArr.size() > maxFreq) {
                maxFreq = heapArr.size();
                maxNum = interval[0];
            }
        }

        // Print the result
        System.out.println("Number " + maxNum + " occurred " + maxFreq + " times");
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 5},
                {2, 4},
                {3, 13},
                {6, 10},
                {10, 12},
                {11, 13}
        };

        intervalSolution(intervals);     }
}
