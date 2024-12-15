package questions.leetcode;

import java.util.PriorityQueue;

class KthLargestElementInAStream {

    PriorityQueue<Integer> topKHeap;
    int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        this.topKHeap = new PriorityQueue<>();

        for (int element: nums) {
            add(element);
        }
    }

    public int add(int val) {
        if (topKHeap.size() < k) {
            topKHeap.offer(val);
        } else if (topKHeap.peek() < val) {
            topKHeap.poll();
            topKHeap.offer(val);
        }
        return topKHeap.peek();
    }
}