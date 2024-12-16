package questions.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestInAnArray {
    // Can also be done with Quickselect
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i=0; i<k; i++) {
            minHeap.add(nums[i]);
        }

        for (int i=k; i<nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        return minHeap.peek();
    }
}
