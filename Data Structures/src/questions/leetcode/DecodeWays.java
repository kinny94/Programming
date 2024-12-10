package questions.leetcode;

import java.util.Arrays;

public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return numDecodings(s, 0, dp);
    }

    public int numDecodings(String s, int index, int[] dp) {
        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }


        if (index + 1 < s.length()) {
            String concat = String.valueOf(s.charAt(index)) + String.valueOf(s.charAt(index + 1));
            if (Integer.valueOf(concat) >= 10 && Integer.valueOf(concat) <= 26) {
                return dp[index] = numDecodings(s, index + 1, dp) + numDecodings(s, index + 2, dp);
            }
        }

        return dp[index] = numDecodings(s, index + 1,  dp);
    }
}
