package questions.leetcode;

public class SumOfAllSubsetXORTotals {
    public int subsetXORSum(int[] nums) {
        int output = 0;

        for (int num : nums) {
            output |= num;
        }

        return output << (nums.length - 1);
    }
}

