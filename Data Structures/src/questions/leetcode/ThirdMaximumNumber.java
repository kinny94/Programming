package questions.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> taken = new HashSet<>();

        for (int num: nums) {
            if (taken.contains(num)) {
                continue;
            }

            if (minHeap.size() == 3) {
                if (minHeap.peek() < num) {
                    taken.remove(minHeap.poll());
                    minHeap.offer(num);
                    taken.add(num);
                }
            } else {
                minHeap.offer(num);
                taken.add(num);
            }
        }

        if (minHeap.size()== 1) {
            return minHeap.peek();
        } else if (minHeap.size() == 2) {
            int firstNum = minHeap.poll();
            return Math.max(firstNum, minHeap.peek());
        }
        return minHeap.peek();
    }
}
