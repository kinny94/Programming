package questions.leetcode;

import java.util.*;

public class TopKFrequentElement {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));

        for (int n: count.keySet()) {
            maxHeap.add(n);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[] top = new int[k];
        for (int i=k-1; i>=0; i--) {
            top[i] = maxHeap.poll();
        }
        return top;
       */

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> frequencies = new ArrayList<>();
        for (int count : frequencyMap.values()) {
            frequencies.add(count);
        }

        int threshold = quickSelect(frequencies, k);

        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() >= threshold) {
                resultList.add(entry.getKey());
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    private int quickSelect(List<Integer> list, int k) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();

        int pivotIndex = new Random().nextInt(list.size());
        int pivot = list.get(pivotIndex);

        for (int num : list) {
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
