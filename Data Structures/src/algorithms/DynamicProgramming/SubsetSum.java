package algorithms.DynamicProgramming;

public class SubsetSum {

    private boolean[][] dp;
    private int[] nums;
    private int m;

    SubsetSum(int[] nums, int m) {
        this.m = m;
        this.nums = nums;
        this.dp = new boolean[nums.length + 1][m + 1];
    }

    public void solve() {
        // first row is false by default. if m is 0 then we can make the empty subset to make sum 0
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        // we can consider all the N+1 rows and M+1 columns
        for (int rowIndex = 1; rowIndex < nums.length + 1; rowIndex++) {
            for (int colIndex = 0; colIndex < m+1; colIndex++) {
                if (colIndex < nums[rowIndex - 1]) {
                    dp[rowIndex][colIndex] = dp[rowIndex - 1][colIndex];
                } else {
                    // we gonna decide if we wanna include this item or not
                    if (dp[rowIndex - 1][colIndex]) {
                        dp[rowIndex][colIndex] = dp[rowIndex - 1][colIndex];
                    } else {
                        // we can include the item
                        dp[rowIndex][colIndex] = dp[rowIndex - 1][colIndex - nums[rowIndex - 1]];
                    }
                }
            }
        }
    }

    public void showResult() {
        System.out.println("There is a feasible solution: " + dp[nums.length][m]);

        if (!dp[nums.length][m]) {
            return;
        }

        int colIndex = this.m;
        int rowIndex = this.nums.length;

        while (rowIndex > 0 && colIndex > 0) {
            if (dp[rowIndex][colIndex] == dp[rowIndex - 1][colIndex]) {
                rowIndex--;
            } else {
                System.out.println("We take item: " + nums[rowIndex - 1]);
                colIndex = colIndex - nums[rowIndex - 1];
                rowIndex--;
            }
        };
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 4, 3, 6, 5, 9, 11};
        int m = 43;
        SubsetSum subsetSum = new SubsetSum(nums, m);
        subsetSum.solve();
        subsetSum.showResult();
    }
}
