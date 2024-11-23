package algorithms.DynamicProgramming;

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

    // also known as Kadane's Algorithm
    public static void main(String[] args) {
        int[] n = {1, -2, 2, 3, 1};
        MaximumSubarray solution = new MaximumSubarray();
        System.out.println(solution.solve(n));
    }
}
