package questions.leetcode;

import java.util.Arrays;

public class MinimumSubsetDifference {
    public static int minimumSubsetDifference(int[] arr) {
        int maxSum = Arrays.stream(arr).sum();
        int[][] dp = new int[arr.length][maxSum + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1)); // Fill dp array with -1 (uncomputed state)
        return solve(arr, 0, 0, maxSum, dp);
    }

    private static int solve(int[] arr, int index, int currentSum, int maxSum, int[][] dp) {
        // Base case
        if (index == arr.length) {
            return Math.abs(maxSum - 2 * currentSum); // Return the difference for the current partition
        }

        // Check if the result for this state is already computed
        if (dp[index][currentSum] != -1) {
            return dp[index][currentSum];
        }

        // Include the current element in the subset
        int include = solve(arr, index + 1, currentSum + arr[index], maxSum, dp);

        // Exclude the current element from the subset
        int exclude = solve(arr, index + 1, currentSum, maxSum, dp);

        // Store and return the minimum difference for this state
        return dp[index][currentSum] = Math.min(include, exclude);
    }
}
