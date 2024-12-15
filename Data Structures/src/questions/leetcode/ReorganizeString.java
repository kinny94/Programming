package questions.leetcode;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c: s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxFreq = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> b.getValue() - a.getValue());
        maxFreq.addAll(charCount.entrySet());

        Map.Entry<Character, Integer> previous = null;
        StringBuilder result = new StringBuilder(s.length());
        while (!maxFreq.isEmpty() || previous != null) {
            if (previous != null && maxFreq.isEmpty()) {
                return "";
            }

            Map.Entry<Character, Integer> currentEntry = maxFreq.poll();
            int count = currentEntry.getValue() - 1;
            result.append(currentEntry.getKey());

            if (previous != null) {
                maxFreq.add(previous);
                previous = null;
            }

            if (count != 0){
                previous = new AbstractMap.SimpleEntry<>(currentEntry.getKey(), count);
            }
        }
        return result.toString();
    }
}
