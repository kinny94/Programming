package questions.leetcode;

public class MatrixChainProblem {
    public static int chain(int[][] matrices) {
        int n = matrices.length;
        int[][] dp = new int[n][n];

        for (int d=1; d<n; d++) {
            for (int i=0; i<n-d; i++) {
                int j = i + d;
                int minCost = Integer.MAX_VALUE;

                for (int k=i; k<j; k++) {
                    int leftCost = dp[i][k];
                    int rightCost = dp[k+1][j];
                    int productCost = matrices[i][0] * matrices[k][1] * matrices[j][1];
                    minCost = Math.min(minCost, leftCost + rightCost + productCost);
                }
                dp[i][j] = minCost;
            }
        }
        return dp[0][n-1];
    }
}
