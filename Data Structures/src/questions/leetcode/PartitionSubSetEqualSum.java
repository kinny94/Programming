package questions.leetcode;

public class PartitionSubSetEqualSum {
    public boolean canPartition(int[] nums) {
        int targetSum = 0;
        for (int item: nums) {
            targetSum += item;
        }

        if (targetSum % 2 != 0) {
            return false;
        }

        int target = targetSum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];
        return canPartition(0, target, nums, dp);
    }

    private boolean canPartition(int index, int target, int[] arr, Boolean[][] dp) {

        if (target == 0) {
            return true;
        }

        if (index == arr.length || target < 0) {
            return false;
        }

        if (dp[index][target] != null) {
            return dp[index][target];
        }

        return dp[index][target] = canPartition(index + 1, target - arr[index], arr, dp) || canPartition(index+ 1, target, arr, dp);
    }
}
