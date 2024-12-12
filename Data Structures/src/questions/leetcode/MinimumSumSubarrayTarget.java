package questions.leetcode;

public class MinimumSumSubarrayTarget {
    public int minSubArrayLen(int target, int[] nums) {
        int windowSize = Integer.MAX_VALUE;
        int start = 0;
        int currSubArrSize = 0;
        int sum = 0;

        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                currSubArrSize = i + 1 - start;
                windowSize = Math.min(windowSize, currSubArrSize);
                sum -= nums[start];
                start++;
            }
        }

        return windowSize == Integer.MAX_VALUE ? 0 : windowSize;
    }
}
