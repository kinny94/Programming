package questions.leetcode;

public class SortColors {
    public void sortColors(int[] nums) {
        int start = 0;
        int current = 0;
        int end = nums.length - 1;

        while(current <= end) {
            if (nums[current] == 0) {
                swap(start, current, nums);
                start++;
                current++;
            } else if (nums[current] == 1) {
                current++;
            } else {
                swap(current, end, nums);
                end--;
            }
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
