package questions.leetcode;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int index = 0;
        int value = 0;

        while (index < n) {
            value = nums[index];
            if (value < n && value != nums[value]) {
                int temp = nums[index];
                nums[index] = nums[value];
                nums[value] = temp;
            } else {
                index++;
            }
        }

        for (int i=0; i<n; i++) {
            if (i != nums[i]) {
                return i;
            }
        }

        return n;
    }
}
