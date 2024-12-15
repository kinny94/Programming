package questions.leetcode;

import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestNumberInMSortedLists {
    public static int kSmallestNumber(List<List<Integer>> lists, int k) {
        int length = lists.size();
        PriorityQueue<int[]> kthSmallest = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i=0; i<length; i++) {
            if (lists.get(i).size() == 0) {
                continue;
            } else {
                kthSmallest.offer(new int[]{lists.get(i).get(0), i, 0});
            }
        }

        int numbersChecked = 0;
        int smallestNumber = 0;

        while(!kthSmallest.isEmpty()) {
            int[] smallest = kthSmallest.poll();
            smallestNumber = smallest[0];
            int listNumber = smallest[1];
            int numIndex = smallest[2];
            numbersChecked++;

            if (numbersChecked == k) {
                break;
            }

            if (numIndex + 1 < lists.get(smallest[1]).size()) {
                kthSmallest.offer(new int[] {lists.get(listNumber).get(numIndex + 1), listNumber, numIndex + 1});
            }
        }
        return smallestNumber;
    }
}
