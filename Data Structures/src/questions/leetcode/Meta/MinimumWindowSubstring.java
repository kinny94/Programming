package questions.leetcode.Meta;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String c) {
        if (s == null || c == null || s.length() == 0 || c.length() == 0 || c.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char ch: c.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int start = 0;
        int matched = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for(int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);

            // If the character is in map..decrement valye
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) >= 0) {
                    matched++;
                }
            }

            // when all the characters are matched
            while(matched == c.length()) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    startIndex = start;
                }

                char startChar = s.charAt(start);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) > 0) {
                        matched--;
                    }
                }
                start++;
            }

        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
