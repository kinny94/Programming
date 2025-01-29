package questions.leetcode.Meta;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c: s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for(char c: order.toCharArray()) {
            if (freq.containsKey(c)) {
                for (int i=0; i<freq.get(c); i++) {
                    sb.append(c);
                }
                freq.remove(c);
            }
        }

        for (Map.Entry<Character, Integer> entry: freq.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            for (int i=0; i<count; i++) {
                sb.append(c);
            }
        }

        return sb.toString();

    }
}
