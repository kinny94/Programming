package questions.leetcode;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {

        if (m == 1 && n == 1) {
            return 1;
        }
        int[][] dp = new int[101][101];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return uniquePath(m , n, 0, 0, dp);
    }

    public int uniquePath(int m, int n, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i==m-1 && j==n-1) {
            dp[i][j] = 0;
            return 0;
        } else if (i == m-1 || j == n-1) {
            dp[i][j] = 1;
            return 1;
        } else {
            dp[i][j] = uniquePath(m, n, i+1, j, dp) + uniquePath(m, n, i, j+1, dp);
            return dp[i][j];
        }
    }
}
