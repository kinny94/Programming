package questions.leetcode;

import java.util.Arrays;

public class LongestCommonSubstring {
    public static int longestCommonSubstring(String s1, String s2)  {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            Arrays.fill(dp[i], -1); // Initialize memoization table
        }

        int[] maxLength = new int[]{0}; // To track the maximum length
        solve(s1, s2, 0, 0, dp, maxLength);
        return maxLength[0];
    }

    private static int solve(String s1, String s2, int i, int j, int[][] dp, int[] maxLength) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        // If the value is already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int count = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            count = 1 + solve(s1, s2, i + 1, j + 1, dp, maxLength);
            maxLength[0] = Math.max(maxLength[0], count); // Update max length
        }

        // Store result in dp and reset count if characters don't match
        dp[i][j] = count;

        // Recursive calls to move to the next indices
        solve(s1, s2, i + 1, j, dp, maxLength);
        solve(s1, s2, i, j + 1, dp, maxLength);

        return count;
    }
}
