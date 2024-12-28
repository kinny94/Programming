package questions.leetcode;

import java.util.Arrays;

public class PalindromeParitioningII {
    public int minCut(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return solve(s, 0, s.length() - 1, dp);
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    private int solve(String s, int start, int end, int[][] dp) {

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        if (start >= end || isPalindrome(s, start, end)) {
            return dp[start][end] = 0; // No cut needed if it's already a palindrome
        }

        int min = Integer.MAX_VALUE;
        for (int k = start; k < end; k++) {
            if (isPalindrome(s, start, k)) { // Only split if the left part is a palindrome
                int temp = 1 + solve(s, k + 1, end, dp);
                min = Math.min(min, temp);
            }
        }
        return dp[start][end] = min;
    }
}
