package questions.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strings) {
            StringBuilder pattern = new StringBuilder();
            for (int i=1; i<str.length(); i++) {
                char prev = str.charAt(i - 1);
                char curr = str.charAt(i);
                int distance = computeDistance(prev, curr);
                pattern.append(distance).append(',');
            }
            String pat = pattern.toString();
            List<String> list = map.containsKey(pat) ? map.get(pat) : new ArrayList<>();
            list.add(str);
            map.put(pat, list);
        }
        return new ArrayList<>(map.values());
    }

    private int computeDistance(char prev, char curr) {
        int val1 = (prev - 'a') + 1;
        int val2 = (curr - 'a') + 1;
        return val1 < val2 ? val2 - val1 : (26 - val1) + val2;
    }
}
