package questions.leetcode;

import java.util.Arrays;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int maxSum = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length + 1][2 * maxSum + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return solve(nums, 0, 0, target, dp, maxSum);
    }

    public int solve(int[] nums, int index, int currentSum, int targetSum, int[][] dp, int maxSum) {
        if (index == nums.length) {
            if (currentSum == targetSum) {
                return 1;
            }
            return 0;
        }

        int dpIndex = currentSum + maxSum;
        if (dp[index][dpIndex] != -1) {
            return dp[index][dpIndex];
        }

        return dp[index][dpIndex] = solve(nums, index + 1, currentSum + nums[index], targetSum, dp, maxSum) + solve(nums, index + 1, currentSum - nums[index], targetSum, dp, maxSum);
    }
}
