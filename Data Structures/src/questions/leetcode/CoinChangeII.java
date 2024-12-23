package questions.leetcode;

import java.util.Arrays;

public class CoinChangeII {
    public static int coinChange(int[] arr, int targetSum) {
        int[][] dp = new int[arr.length + 1][targetSum + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return solve(arr,0, targetSum);
    }
    public static int solve(int[] arr, int index, int currentSum) {

        if (index == arr.length || currentSum < 0) {
            return 0;
        }

        if (currentSum == 0) {
            return 1;
        }

        return solve(arr, index, currentSum - arr[index]) + solve(arr, index + 1, currentSum);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        System.out.println(coinChange(arr, 11));
    }
}
