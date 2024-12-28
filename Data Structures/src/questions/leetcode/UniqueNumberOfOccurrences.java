package questions.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: arr) {
            map.put(num,  map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> seen = new HashSet<>();
        for (int count: map.values()) {
            if (seen.contains(count)) {
                return false;
            }
            seen.add(count);
        }

        return true;
    }
}
