package questions.leetcode;
public class FindCorruptPair{
    public static int[] findCorruptPair(int[] nums) {
        int duplicate = 0;
        int missing = 0;
        int[] pair = {0, 0};
        int index = 0;

        while (index < nums.length) {
            int correctSpot = nums[index] - 1;
            if (nums[index] != nums[correctSpot]) {
                int temp = nums[index];
                nums[index] = nums[correctSpot];
                nums[correctSpot] = temp;
            } else {
                index++;
            }
        }

        for (int i=0; i<nums.length; i++) {
            if (nums[i]  != i+1) {
                duplicate = nums[i];
                missing = i + 1;
            }
        }

        pair[0] = missing;
        pair[1] = duplicate;
        return pair;
    }
}