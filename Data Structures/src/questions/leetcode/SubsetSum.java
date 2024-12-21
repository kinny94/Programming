package questions.leetcode;

public class SubsetSum {
    public static boolean subsetSum(int[] arr, int sum) {
        Boolean dp[][] = new Boolean[arr.length + 1][sum + 1];
        return solve(arr, sum, 0, dp);
    }

    private static boolean solve(int[] arr, int sum, int index, Boolean[][] dp) {
        if (sum == 0) {
            return true;
        }

        if (index == arr.length || sum < 0) {
            return false;
        }

        if (dp[index][sum] != null) {
            return dp[index][sum];
        }

        return dp[index][sum] = solve(arr, sum - arr[index],  index + 1, dp) || solve(arr, sum,  index + 1, dp);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{34, 4, 12, 5};
        System.out.println(subsetSum(arr,16));
    }
}
