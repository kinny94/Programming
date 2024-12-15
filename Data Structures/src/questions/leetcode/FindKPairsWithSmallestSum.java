package questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        class Pair {
            int sum;
            int list1Index;
            int list2Index;

            Pair(int sum, int list1Index, int list2Index) {
                this.sum = sum;
                this.list1Index = list1Index;
                this.list2Index = list2Index;
            }
        }

        List<List<Integer>> pairs = new ArrayList<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.sum - b.sum);

        for (int i=0; i<Math.min(k, nums1.length); i++) {
            minHeap.add(new Pair(nums1[i] + nums2[0], i, 0));
        }

        int counter = 1;

        while(!minHeap.isEmpty() && counter <= k) {
            Pair pair = minHeap.poll();
            int i = pair.list1Index;
            int j = pair.list2Index;
            pairs.add(Arrays.asList(nums1[i], nums2[j]));

            if (nums2.length > j + 1) {
                minHeap.offer(new Pair(nums1[i] + nums2[j + 1], i, j + 1));
            }
            counter++;
        }
        return pairs;
    }
}
