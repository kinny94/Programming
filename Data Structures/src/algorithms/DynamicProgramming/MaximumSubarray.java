package algorithms.DynamicProgramming;

import java.util.Arrays;

public class MaximumSubarray {

    public int solve(int[] nums) {
        int globalMax = nums[0];
        int localMax = nums[0];

        for (int i=1; i<nums.length; i++) {
            localMax = Math.max(nums[i], localMax + nums[i]);

            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }
        return globalMax;
    }

    public int[] solveWithSubarray(int[] nums) {
        int globalMax = nums[0];
        int localMax = nums[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i=1; i<nums.length; i++) {
            if (nums[i] > localMax + nums[i]) {
                localMax = nums[i];
                tempStart = i;
            } else {
                localMax = localMax + nums[i];
            }

            if (localMax > globalMax) {
                globalMax = localMax;
                start = tempStart;
                end = i;
            }
        }

        int[] subarray = Arrays.copyOfRange(nums, start, end + 1);
        System.out.println("Maximum Sum: " + globalMax);
        System.out.println("Subarray: " + Arrays.toString(subarray));
        return subarray;
    }


    // also known as Kadane's Algorithm
    public static void main(String[] args) {
        int[] n = {1, -2, 2, 3, 1};
        MaximumSubarray solution = new MaximumSubarray();
        System.out.println(solution.solve(n));
        System.out.println(Arrays.toString(solution.solveWithSubarray(n)));
    }
}
