package questions.leetcode;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            for (int i : nums) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
