package questions.leetcode;

import java.util.Arrays;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();

        if (n + m != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[n + 1][m + 1];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, false));
        dp[0][0] = true;

        for (int j = 1; j < m + 1; j++) {
            dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1];
        }

        for (int i=1; i<n + 1; i++) {
            dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i-1][0];
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                boolean checkS1 = s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j];
                boolean checkS2 = s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1];
                dp[i][j] = checkS1 || checkS2;

            }
        }

        return dp[n][m];
    }
}
