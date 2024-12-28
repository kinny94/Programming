package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitioningPalindrome {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        solve(s, 0, new ArrayList<>(), result, dp);
        return result;
    }

    private void solve(String s, int start, List<String> currentList, List<List<String>> result, boolean[][] dp) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(currentList));
        }

        for (int k=start; k<s.length(); k++) {
            if (s.charAt(start) == s.charAt(k) && (k - start <= 2 || dp[start + 1][k - 1])) {
                dp[start][k] = true;
                currentList.add(s.substring(start, k + 1));
                solve(s, k + 1, currentList, result, dp);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
