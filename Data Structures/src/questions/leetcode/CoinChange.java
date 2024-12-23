package questions.leetcode;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int result = solve(coins, 0, amount, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int solve(int[] coins, int index, int currentAmount, int[][] dp) {
        if (currentAmount == 0) {
            return 0; // No coins needed to make amount 0
        }

        if (index == coins.length || currentAmount < 0) {
            return Integer.MAX_VALUE; // Invalid state
        }

        if (dp[index][currentAmount] != -1) {
            return dp[index][currentAmount];
        }


        int include = solve(coins, index, currentAmount - coins[index], dp);
        if (include != Integer.MAX_VALUE) {
            include += 1;
        }

        int exclude = solve(coins, index + 1, currentAmount, dp);

        dp[index][currentAmount] = Math.min(include, exclude);
        return dp[index][currentAmount];
    }
}
