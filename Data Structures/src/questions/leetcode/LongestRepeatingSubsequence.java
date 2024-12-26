package questions.leetcode;

import java.util.Arrays;

public class LongestRepeatingSubsequence {
    public int LongestRepeatingSubsequence(String s1) {
        int[][] dp = new int[s1.length() + 1][s1.length() + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return solve(s1, s1, 0, 0, dp);
        // code here
    }

    private static int solve(String s1, String s2, int s1Index, int s2Index, int[][] dp) {
        if (s1Index == s1.length() || s2Index == s2.length()) {
            return 0;
        }

        if (dp[s1Index][s2Index] != -1) {
            return dp[s1Index][s2Index];
        }

        if (s1.charAt(s1Index) == s2.charAt(s2Index) && s1Index != s2Index) {
            return dp[s1Index][s2Index] = 1 + solve(s1, s2, s1Index + 1, s2Index + 1, dp);
        }

        return dp[s1Index][s2Index] = Math.max(
                solve(s1, s2, s1Index + 1, s2Index, dp),
                solve(s1, s2, s1Index, s2Index + 1, dp)
        );
    }
}
