package questions.leetcode;

import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[1000];
        Arrays.fill(dp, -1);
        return rob(nums, 0, dp);
    }

    private int rob(int[] nums, int index, int[] dp) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int ans = Math.max(nums[index] + rob(nums, index + 2, dp), rob(nums, index + 1, dp));
        dp[index] = ans;
        return ans;
    }
}
