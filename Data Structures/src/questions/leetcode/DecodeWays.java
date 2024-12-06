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

        if (dp[index] != -1) {
            return dp[index];
        }

        int ans = 0;
        if (s.charAt(index) == 0) {
            return 0;
        }

        if (s.charAt(index) >= '1' && s.charAt(index) <= '9') {
            ans += numDecodings(s, index+1, dp);
        }

        if (index + 1 < s.length() && s.charAt(index) == '1') {
            ans += numDecodings(s, index + 2, dp);
        }

        if (index + 1 < s.length() && (s.charAt(index) == '2' && s.charAt(index + 1) <= '6')) {
            ans += numDecodings(s, index + 2, dp);
        }
        dp[index] = ans;
        return ans;
    }
}
