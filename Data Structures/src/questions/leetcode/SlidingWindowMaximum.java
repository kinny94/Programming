package questions.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static Deque<Integer> cleanUp(int i, Deque<Integer> currentWindow, int[] nums) {
        while(currentWindow.size() != 0 && nums[i] >= nums[currentWindow.getLast()]) {
            currentWindow.removeLast();
        }
        return currentWindow;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }

        int[] output = new int[nums.length - k + 1];
        Deque<Integer> currentWindow = new ArrayDeque<>();
        for (int i=0; i<k; i++) {
            currentWindow = cleanUp(i, currentWindow, nums);
            currentWindow.add(i);
        }

        output[0] = nums[currentWindow.getFirst()];
        for (int i=k; i<nums.length; i++) {
            cleanUp(i, currentWindow, nums);
            if (!currentWindow.isEmpty() && currentWindow.getFirst() <= (i-k)) {
                currentWindow.removeFirst();
            }
            currentWindow.add(i);
            output[i-k+1] = nums[currentWindow.getFirst()];
        }
        return output;
    }
}
