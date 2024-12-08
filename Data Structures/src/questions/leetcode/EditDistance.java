package questions.leetcode;

import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));
        return minDistance(0, 0, word1, word2, dp);
    }

    public int minDistance(int i, int j, String s1, String s2, int[][] dp) {

        if (i == s1.length()) {
            return s2.length() - j;
        }

        if (j == s2.length()) {
            return s1.length() - i;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = minDistance(i+1, j+1, s1, s2, dp);
            return dp[i][j];
        }

        int insert = minDistance(i, j+1, s1, s2, dp);
        int delete = minDistance(i+1, j, s1, s2, dp);
        int replace = minDistance(i+1, j+1, s1, s2, dp);
        dp[i][j] =1 + Math.min(insert, Math.min(delete, replace));
        return dp[i][j];

    }
}
