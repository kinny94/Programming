package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeByConcatTwoLetterWord {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> frequencies = new HashMap<>();

        for(String word: words) {
            frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
        }

        int count = 0;
        boolean central = false;

        for (Map.Entry<String, Integer> entry: frequencies.entrySet()) {
            String word = entry.getKey();
            int freq = entry.getValue();

            if (word.charAt(0) == word.charAt(1)) {
                if (freq % 2 == 0) {
                    count += freq;
                } else {
                    count += freq - 1;
                    central = true;
                }
            } else if (word.charAt(1) > word.charAt(0) && frequencies.containsKey(word.charAt(1) + "" + word.charAt(0))) {
                count += 2 * Math.min(freq,  frequencies.get(word.charAt(1) + "" + word.charAt(0)));
            }
        }

        if (central) {
            count += 1;
        }

        return 2 * count;
    }
}
