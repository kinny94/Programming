package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int windowStart = 0;
        int windowLength = 0;
        int i;
        int longest = 0;

        Map<Character, Integer> lastSeenAt = new HashMap<>();

        for (i=0; i<s.length(); i++) {
            if (!lastSeenAt.containsKey(s.charAt(i))) {
                lastSeenAt.put(s.charAt(i), i);
            } else {
                if (lastSeenAt.get(s.charAt(i)) >= windowStart) {
                    windowLength = i - windowStart;
                    if (longest <= windowLength) {
                        longest = windowLength;
                    }
                    windowStart = lastSeenAt.get(s.charAt(i)) + 1;
                }
                lastSeenAt.replace(s.charAt(i), i);

            }
        }

        return longest > i - windowStart ? longest : i - windowStart;

    }
}
