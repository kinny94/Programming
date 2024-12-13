package questions.leetcode;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c:  tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> sortedFreq = new ArrayList<>(map.entrySet());
        Collections.sort(sortedFreq, (lhs, rhs) -> lhs.getValue().compareTo(rhs.getValue()));

        int maxFreq = sortedFreq.get(sortedFreq.size() - 1).getValue();
        sortedFreq.remove(sortedFreq.size() - 1);

        int idleTime = (maxFreq - 1) * n;
        while (!sortedFreq.isEmpty() && idleTime > 0) {
            idleTime = idleTime - Math.min(maxFreq - 1, sortedFreq.get(sortedFreq.size() - 1).getValue());
            sortedFreq.remove(sortedFreq.size() - 1);
        }
        idleTime = Math.max(0, idleTime);

        return tasks.length + idleTime;
    }
}
