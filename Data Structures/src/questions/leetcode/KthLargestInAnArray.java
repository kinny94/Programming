package questions.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i=0; i<nums.length; i++) {
            maxHeap.offer(nums[i]);
        }

        for (int i=0; i<k-1; i++) {
            maxHeap.poll();
        }

        return maxHeap.peek();
    }
}
