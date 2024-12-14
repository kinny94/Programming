package questions.leetcode;

public class CountVowelPermutation {
    public int countVowelPermutation(int n) {
        int MOD = 1_000_000_007;

        // dp[i][j] represents the number of strings of length i ending with the j-th vowel
        long[][] dp = new long[n + 1][5];

        // Initialize base case: For length 1, each vowel can be a starting point
        for (int j = 0; j < 5; j++) {
            dp[1][j] = 1;
        }

        // Fill the DP table for lengths 2 to n
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % MOD; // 'a' can follow 'e', 'i', 'u'
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;               // 'e' can follow 'a', 'i'
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % MOD;               // 'i' can follow 'e', 'o'
            dp[i][3] = dp[i - 1][2] % MOD;                               // 'o' can follow 'i'
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;               // 'u' can follow 'i', 'o'
        }

        // Sum up all permutations of length n
        long result = 0;
        for (int j = 0; j < 5; j++) {
            result = (result + dp[n][j]) % MOD;
        }

        return (int) result;
    }
}
