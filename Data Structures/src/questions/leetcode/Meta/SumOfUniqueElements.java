package questions.leetcode.Meta;

import java.util.Arrays;

public class SumOfUniqueElements {
    public int sumOfUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);
        int sum = 0;
        for (int i=0; i<nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }


            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }

            sum += nums[i];
        }
        return sum;
    }
}
