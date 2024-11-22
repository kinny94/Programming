package algorithms.DynamicProgramming;

public class RodCutting {

    private int rodLength;
    private int[][] dp;
    private int[] prices;

    RodCutting(int rodLength, int[] prices) {
        this.rodLength = rodLength;
        this.prices = prices;
        this.dp = new int[prices.length + 1][rodLength + 1];
    }

    public void solve() {
        for (int i = 1; i < prices.length + 1; i++) {
            for (int j = 1; j < rodLength + 1; j++) {
                if (i<=j) {
                    dp[i][j] = Math.max(dp[i-1][j], prices[i] + dp[i][j-i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }

    public void show() {
        System.out.println("Optimal profit: " + dp[prices.length - 1][rodLength]);
        for (int rowIndex=prices.length - 1,colIndex=rodLength; rowIndex>0;) {
            if (dp[rowIndex][colIndex] != 0 && dp[rowIndex][colIndex] != dp[rowIndex-1][colIndex]) {
                System.out.println("We use piece " + rowIndex + "m");
                colIndex = colIndex - rowIndex;
            } else {
                 rowIndex--;
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] prices = {0, 2, 5, 7, 3, 9};
        RodCutting c = new RodCutting(n, prices);
        c.solve();
        c.show();
    }
}
