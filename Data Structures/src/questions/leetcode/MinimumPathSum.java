package questions.leetcode;

import java.util.Arrays;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[201][201];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return minPathSum(grid, 0, 0, dp);
    }

    public int minPathSum(int[][] grid, int i, int j, int[][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i == m-1 && j == n-1) {
            dp[i][j] = grid[i][j];
            return dp[i][j];
        } else if (i == m-1) {
            dp[i][j] = grid[i][j] + minPathSum(grid, i, j+1, dp);
            return dp[i][j];
        } else if (j == n-1) {
            dp[i][j] = grid[i][j] + minPathSum(grid, i + 1, j, dp);
            return dp[i][j];
        } else {
            dp[i][j] = grid[i][j] + Math.min(minPathSum(grid, i, j + 1, dp), minPathSum(grid, i+1, j, dp));
            return dp[i][j];
        }

    }
}
