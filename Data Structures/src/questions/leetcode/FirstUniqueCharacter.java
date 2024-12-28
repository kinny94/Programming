package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        Map<Character, Integer> wordCount = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            wordCount.put(ch, wordCount.getOrDefault(ch, 0) + 1);
        }

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (wordCount.get(ch) == 1) {
                return i;
            }
        }

        return -1;
    }
}
