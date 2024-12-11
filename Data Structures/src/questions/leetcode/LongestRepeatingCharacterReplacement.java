package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int lengthOfMaxSubstring = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int mostFreqChar = 0;

        for (int end = 0; end<s.length(); end++) {
            char currChar = s.charAt(end);
            freq.put(currChar, freq.getOrDefault(currChar, 0) + 1);
            mostFreqChar = Math.max(mostFreqChar, freq.get(currChar));
            if (end - start + 1 - mostFreqChar > k) {
                freq.put(s.charAt(start), freq.get(s.charAt(start)) -1);
                start++;
            }
            lengthOfMaxSubstring = Math.max(lengthOfMaxSubstring, end - start + 1);
        }
        return lengthOfMaxSubstring;
    }
}
