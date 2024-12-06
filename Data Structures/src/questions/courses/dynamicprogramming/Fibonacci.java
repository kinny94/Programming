package questions.courses.dynamicprogramming;

import java.util.Arrays;

public class Fibonacci {
    public static int memoizedFibonacci(int num) {
        int[] dp = new int[num + 1];
        Arrays.fill(dp, -1);

        if (num <= 2) {
            return 1;
        }

        if (dp[num] != -1) {
            return dp[num];
        }
        return dp[num] = memoizedFibonacci(num - 1) + memoizedFibonacci(num - 2);
    }

    // faster
    public static int tabularFibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(memoizedFibonacci(n));
        System.out.println(tabularFibonacci(n));
    }
}
