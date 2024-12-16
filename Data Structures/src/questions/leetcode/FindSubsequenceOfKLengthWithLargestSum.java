package questions.leetcode;

import java.util.*;

public class FindSubsequenceOfKLengthWithLargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i=0; i<nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i});

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<int[]> pairList = new ArrayList<>(minHeap);
        pairList.sort(Comparator.comparingInt(a -> a[1]));
        int[] result = new int[k];
        for (int i=0; i<k; i++) {
            result[i] = pairList.get(i)[0];
        }
        return result;
    }
}
