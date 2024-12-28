package questions.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Set<Character> characterSet = new HashSet<>();
        int res = 0;

        for (char c : s.toCharArray()) {
            if (characterSet.contains(c)) {
                characterSet.remove(c);
                res += 2;
            } else {
                // add the character to the set
                characterSet.add(c);
            }
        }

        if (!characterSet.isEmpty()) res++;

        return res;
    }
}
