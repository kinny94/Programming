package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> reqCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c: t.toCharArray()) {
            reqCount.put(c, reqCount.getOrDefault(c, 0) + 1);
        }

        int requred = reqCount.size();
        int current = 0;
        int[] result = {-1, -1};
        int resultLength = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (reqCount.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(reqCount.get(c))) {
                    current++;
                }
            }

            while (current == requred) {
                if ((right - left + 1) < resultLength) {
                    result[0] = left;
                    result[1] = right;
                    resultLength = right - left + 1;
                }

                char leftChar = s.charAt(left);
                if (reqCount.containsKey(leftChar)) {
                    window.put(leftChar, window.get(leftChar) - 1);
                    if (window.get(leftChar) < reqCount.get(leftChar)) {
                        current--;
                    }
                }
                left++;
            }
        }

        return result[0] == -1 ? "" : s.substring(result[0], result[1] + 1);
    }
}
