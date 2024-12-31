package questions.leetcode;

public class RangeSumQueryImmutable {
    private int[] sum;

    public RangeSumQueryImmutable(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i =0; i<nums.length; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right+1] - sum[left];
    }
}
