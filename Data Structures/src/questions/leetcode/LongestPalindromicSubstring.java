package questions.leetcode;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        int[][] dp = new int[s.length() + 1][s.length() + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        StringBuilder sb = new StringBuilder();
        solve(s, 0, s.length() - 1, sb, dp);
        return sb.toString();
    }

    private int solve(String s, int start, int end, StringBuilder longest, int[][] dp) {
        // Base cases
        if (start > end) {
            return 0; // Empty substring
        }

        if (start == end) {
            // Single character is always a palindrome
            if (longest.length() < 1) {
                longest.setLength(0);
                longest.append(s.charAt(start));
            }
            return 1;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }


        // Check if the current substring is a palindrome
        if (s.charAt(start) == s.charAt(end) && solve(s, start + 1, end - 1, longest, dp) == (end - start - 1)) {
            int currentLength = end - start + 1;
            if (currentLength > longest.length()) {
                longest.setLength(0);
                longest.append(s.substring(start, end + 1));
            }
            return dp[start][end] = currentLength;
        }

        // Otherwise, explore both possibilities: skipping either end
        solve(s, start + 1, end, longest, dp);
        solve(s, start, end - 1, longest, dp);

        return dp[start][end] = 0; // Not
    }
}
