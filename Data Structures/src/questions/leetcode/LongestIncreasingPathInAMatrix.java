package questions.leetcode;

public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                int len = dfs(matrix, i, j, dp);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] dp) {

        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int max = 1;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] direction: directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[0].length || matrix[newRow][newCol] <= matrix[row][col]) {
                continue;
            }
            int len = 1 + dfs(matrix, newRow, newCol, dp);
            max = Math.max(max, len);
        }
        dp[row][col] = max;
        return max;
    }
}
