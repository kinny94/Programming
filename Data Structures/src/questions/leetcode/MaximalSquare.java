package questions.leetcode;

import java.util.Arrays;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[rows + 1][col + 1];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));

        if (matrix == null || rows == 0 || col == 0) {
            return 0;
        }

        int maxSide = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                maxSide = Math.max(maxSide, rec(matrix, i, j, dp));
            }
        }

        return maxSide * maxSide;
    }

    public int rec(char[][] matrix, int i, int j, int[][] dp) {
        if (i < 0 || j < 0 || matrix[i][j] == '0') {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = 1 + Math.min(Math.min(rec(matrix, i-1, j, dp), rec(matrix, i, j-1, dp)), rec(matrix, i-1, j-1, dp));
        return dp[i][j];
    }
}
