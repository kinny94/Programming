package questions.leetcode;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int minCoints = coinChange(coins, amount, dp);
        return minCoints == Integer.MAX_VALUE ? -1 : minCoints;
    }

    private int coinChange(int[] coins, int amount, int[] dp) {
        if (dp[amount] != -1) {
            return dp[amount];
        }

        if (amount == 0) {
            return dp[amount] = 0;
        }

        int minCoins = Integer.MAX_VALUE;
        for (int coin: coins) {
            if (amount - coin >= 0) {
                int result = coinChange(coins, amount - coin, dp);
                if (result != Integer.MAX_VALUE) {
                    minCoins = Math.min(minCoins, 1 + result);
                }
            }
        }
        return dp[amount] = minCoins;
    }
}
