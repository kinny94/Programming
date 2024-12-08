package questions.leetcode;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastGoodIndex = n - 1;

        for (int i=n-2; i>=0; i--) {
            if (nums[i] + i >= lastGoodIndex) {
                lastGoodIndex = i;
            }
        }
        return lastGoodIndex == 0;
    }
}
