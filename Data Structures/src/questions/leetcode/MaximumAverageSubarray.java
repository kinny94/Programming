package questions.leetcode;

public class MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i=0; i<k; i++) {
            sum += nums[i];
        }

        int currentSum = sum;
        for (int i=k; i<nums.length; i++) {
            currentSum = currentSum + nums[i] - nums[i-k];
            sum = Math.max(sum,  currentSum);
        }

        return (double) sum / k;
    }
}
