package questions.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) {
            return new ArrayList<List<String>>();
        }

        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];

        for (String s: strs) {
            Arrays.fill(count, 0);
            for (char c: s.toCharArray()) {
                int index = c - 'a';
                count[index]++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<26; i++) {
                sb.append('#').append(count[i]);
            }

            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
