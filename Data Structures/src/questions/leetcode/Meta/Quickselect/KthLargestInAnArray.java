package questions.leetcode.Meta.Quickselect;

import java.util.*;

public class KthLargestInAnArray {
    // Can also be done with Quickselect
    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        for (int i=0; i<k; i++) {
//            minHeap.add(nums[i]);
//        }
//
//        for (int i=k; i<nums.length; i++) {
//            if (nums[i] > minHeap.peek()) {
//                minHeap.poll();
//                minHeap.add(nums[i]);
//            }
//        }
//
//        return minHeap.peek();

        List<Integer> temp = new ArrayList<>();
        for (int num: nums) {
            temp.add(num);
        }
        return quickSelect(temp, k);
    }

    private int quickSelect(List<Integer> list, int k) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();

        int pivotIndex = new Random().nextInt(list.size());
        int pivot = list.get(pivotIndex);

        for (int num: list) {
            if (num > pivot) {
                left.add(num);
            } else if (num < pivot) {
                right.add(num);
            } else {
                mid.add(num);
            }
        }

        if (k <= left.size()) {
            return quickSelect(left, k);
        }

        if (k > left.size() + mid.size()) {
            return quickSelect(right, k - left.size() - mid.size());
        }

        return pivot;
    }
}
