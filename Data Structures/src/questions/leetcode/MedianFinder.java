package questions.leetcode;

import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> maxHeapForSmallNum;
    PriorityQueue<Integer> minHeapForLargeNum;

    public MedianFinder() {
        maxHeapForSmallNum = new PriorityQueue<>((a, b) -> b - a);
        minHeapForLargeNum = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (maxHeapForSmallNum.isEmpty() || maxHeapForSmallNum.peek() >= num) {
            maxHeapForSmallNum.add(num);
        } else {
            minHeapForLargeNum.add(num);
        }

        if (maxHeapForSmallNum.size() > minHeapForLargeNum.size() + 1) {
            minHeapForLargeNum.add(maxHeapForSmallNum.poll());
        } else if (minHeapForLargeNum.size() > maxHeapForSmallNum.size()) {
            maxHeapForSmallNum.add(minHeapForLargeNum.poll());
        }
    }

    public double findMedian() {
        if (maxHeapForSmallNum.size() == minHeapForLargeNum.size()) {
            return maxHeapForSmallNum.peek() / 2.0 + minHeapForLargeNum.peek() / 2.0;
        } else {
            return maxHeapForSmallNum.peek();
        }
    }
}
