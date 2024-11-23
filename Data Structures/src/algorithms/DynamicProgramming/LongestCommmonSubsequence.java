package algorithms.DynamicProgramming;

public class LongestCommmonSubsequence {

    public String lcs(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        String lcs = "";
        int i = s1.length();
        int j = s2.length();
        while (i > 0 && j > 0) {
            // if the characters are matching then the character is part of the lcs
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs = lcs + s1.charAt(i - 1); // could also use s2.charAt(j-1) as they will same
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                // characters are not matching.. we have to move in the larger item direction
                i--;
            } else {
                j--;
            }
        }

        return new StringBuilder(lcs).reverse().toString();
    }

    public static void main(String[] args) {
        LongestCommmonSubsequence lcs = new LongestCommmonSubsequence();
        System.out.println(lcs.lcs("abcd", "bd"));
        System.out.println(lcs.lcs("abcd", "rtbxxxd"));

    }
}
