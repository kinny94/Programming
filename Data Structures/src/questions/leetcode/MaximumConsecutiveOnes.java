package questions.leetcode;

public class MaximumConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] == 0) {
                k--;
            }

            if (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
        }
        return nums.length - left;
    }
}
