package questions.leetcode.Meta;

public class MaximumConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int windowStart = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                k--;
            }

            if (k < 0) {
                if (nums[windowStart] == 0) {
                    k++;
                }
                windowStart++;
            }
        }
        return nums.length - windowStart;
    }
}
