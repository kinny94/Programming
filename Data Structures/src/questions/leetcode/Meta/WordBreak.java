package questions.leetcode.Meta;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        Map<Integer, Boolean> dp = new HashMap<>();
        return solve(s, wordDict, 0, wordSet, dp);
    }

    private boolean solve(String s, List<String> wordDict, int index, Set<String> set, Map<Integer, Boolean> dp) {
        if (index == s.length()) {
            return true;
        }

        if (dp.containsKey(index)) {
            return dp.get(index);
        }

        for (int i=index + 1; i<=s.length(); i++) {
            String subString = s.substring(index, i);
            if (wordDict.contains(subString) && solve(s, wordDict, i, set, dp)) {
                dp.put(index, true);
                return true;
            }
        }

        dp.put(index, false);
        return false;
    }
}
