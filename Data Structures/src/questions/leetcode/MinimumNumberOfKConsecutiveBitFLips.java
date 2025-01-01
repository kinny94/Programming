package questions.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumNumberOfKConsecutiveBitFLips {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> flipTrackQueue = new ArrayDeque<>();
        int isFlipped = 0;
        int totalFlips = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                isFlipped ^= flipTrackQueue.pollFirst();
            }

            if (isFlipped % 2 == nums[i]) {
                if (i + k > n) {
                    return -1;
                }

                flipTrackQueue.addLast(1);
                isFlipped ^= 1;
                totalFlips++;
            } else {
                flipTrackQueue.addLast(0);
            }
        }

        return totalFlips;
    }
}
