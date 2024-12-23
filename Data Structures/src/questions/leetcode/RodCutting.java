package questions.leetcode;

import java.util.Arrays;

public class RodCutting {
    public int cutRod(int[] price) {
        int[][] dp = new int[price.length + 1][price.length + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return solve(price,0, price.length, dp);
    }

    public static int solve(int[] arr, int index, int remainingLength, int[][] dp) {

        if (index >= arr.length || remainingLength <= 0) {
            return 0;
        }

        if (dp[index][remainingLength] != -1) {
            return dp[index][remainingLength];
        }

        if (index < remainingLength) {
            return dp[index][remainingLength] = Math.max(
                    arr[index] + solve(arr, index, remainingLength - index - 1, dp)
                    , solve(arr, index + 1, remainingLength, dp));
        }

        return dp[index][remainingLength] = solve(arr, index + 1, remainingLength - index - 1, dp);
    }
}
