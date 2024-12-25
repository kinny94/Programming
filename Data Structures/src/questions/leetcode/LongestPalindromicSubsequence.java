package questions.leetcode;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length() + 1][s2.length() + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return solve(s, s2, 0, 0, dp);
    }

    private int solve(String s1, String s2, int s1Index, int s2Index, int[][] dp) {

        if (dp[s1Index][s2Index] != -1) {
            return dp[s1Index][s2Index];
        }

        if (s1Index == s1.length() || s2Index == s2.length()) {
            return 0;
        }

        if (s1.charAt(s1Index) == s2.charAt(s2Index)) {
            return dp[s1Index][s2Index] = 1 + solve(s1, s2, s1Index + 1, s2Index + 1, dp);
        }

        return dp[s1Index][s2Index] = Math.max(solve(s1, s2, s1Index + 1, s2Index, dp), solve(s1, s2, s1Index,  s2Index + 1, dp));
    }
}
