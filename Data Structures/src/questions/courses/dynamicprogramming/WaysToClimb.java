package questions.courses.dynamicprogramming;

import java.util.Arrays;

class WaysToClimb {

    public static int jumps(int[] nums, int n) {
        int[] dp = new int[n + 1]; // Fix size to `n + 1` since `n` is the target
        Arrays.fill(dp, -1); // Initialize with -1 for memoization
        return jumps(nums, n, dp);
    }

    private static int jumps(int[] nums, int n, int[] dp) {
        // Base case: If n is exactly 0, we found a valid way
        if (n == 0) {
            return 1;
        }

        // If n becomes negative, there's no way to reach this point
        if (n < 0) {
            return 0;
        }

        // If already computed, return the memoized value
        if (dp[n] != -1) {
            return dp[n];
        }

        // Initialize dp[n] before adding to it
        dp[n] = 0;

        // Explore all possible "jumps"
        for (int i = 0; i < nums.length; i++) {
            dp[n] += jumps(nums, n - nums[i], dp);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 8};
        int n = 10;
        System.out.println(jumps(arr, n)); // Output the number of ways to reach the target
    }
}