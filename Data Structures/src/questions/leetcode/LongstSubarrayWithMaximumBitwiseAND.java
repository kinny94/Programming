package questions.leetcode;

public class LongstSubarrayWithMaximumBitwiseAND {
    public int longestSubarray(int[] nums) {
        int maximumAND = 0, maximumLength = 0, currentLength = 0;

        for (int num : nums) {
            if (maximumAND < num) {
                maximumAND = num;
                maximumLength = currentLength = 0;
            }

            if (maximumAND == num) {
                currentLength++;
            } else {
                currentLength = 0;
            }

            maximumLength = Math.max(maximumLength, currentLength);
        }

        return maximumLength;
    }
}
