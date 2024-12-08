package questions.leetcode;

import java.util.Arrays;

public class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr,-1));
        int length = scs(0, 0, str1, str2, dp);
        return buildScs(str1, str2, dp);
    }

    private int scs(int i, int j, String s1, String s2, int[][] dp) {

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.length() == i) {
            return dp[i][j] = s2.length() - j;
        }

        if (s2.length() == j) {
            return dp[i][j] = s1.length() - i;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + scs(i+1, j+1, s1, s2, dp);
        }

        return dp[i][j] = 1 + Math.min(scs(i+1, j, s1, s2, dp), scs(i, j+1, s1, s2, dp));
    }

    private static String buildScs(String s1, String s2, int[][] dp) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        int j=0;

        while(i<s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
                i++;
                j++;
            } else if (dp[i+1][j] < dp[i][j+1]) {
                sb.append(s1.charAt(i));
                i++;
            } else {
                sb.append(s2.charAt(j));
                j++;
            }
        }

        while (i <s1.length()) {
            sb.append(s1.charAt(i));
            i++;
        }

        while(j < s2.length()) {
            sb.append(s2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}
