package questions.courses.dynamicprogramming;

import java.util.Arrays;

public class AlphaCode {
    public static int alphaCode(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return alphaCode(s, 0, dp);
    }

    public static int alphaCode(String s, int index, int[] dp) {

        if (index == s.length()) {
            return 1;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int ans = 0;
        if (s.charAt(index) >= '1' && s.charAt(index) <= '9') {
            ans += alphaCode(s, index + 1, dp);
        }

        if (index + 1 < s.length() && s.charAt(index) == '1') {
            return ans += alphaCode(s, index+2, dp);
        }

        if (index + 1 < s.length() && (s.charAt(index) == '2' && s.charAt(index + 1) <= '6')) {
            return ans += alphaCode(s, index + 2, dp);
        }

        dp[index] = ans;
        return ans;
    }

    public static void main(String[] args) {
        String s = "25114";
        System.out.println(alphaCode(s));
    }
}
