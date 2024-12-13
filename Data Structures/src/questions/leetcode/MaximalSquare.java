package questions.leetcode;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[rows + 1][col + 1];

        if (matrix == null || rows == 0 || col == 0) {
            return 0;
        }

        int maxSide = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }
}
