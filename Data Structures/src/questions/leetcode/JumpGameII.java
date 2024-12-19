package questions.leetcode;

public class JumpGameII {
    public int jump(int[] nums) {
        int farthestJump = 0;
        int currentJump = 0;
        int jumps = 0;

        for (int i=0; i<nums.length - 1; i++) {
            farthestJump = Math.max(farthestJump, i + nums[i]);
            if (i == currentJump) {
                jumps++;
                currentJump = farthestJump;
            }
        }

        return jumps;

        // if (nums.length == 1) {
        //     return 0;
        // }
        // int n = nums.length;
        // int[] dp = new int[nums.length];
        // Arrays.fill(dp, Integer.MAX_VALUE);
        // dp[0] = 0;
        // for (int i=1; i<nums.length; i++) {
        //     for (int j=0; j<i; j++) {
        //         if (j + nums[j] >= i) {
        //             dp[i] = Math.min(dp[i], dp[j] + 1);
        //         }
        //     }
        // }
        // return dp[n-1];
    }
}
