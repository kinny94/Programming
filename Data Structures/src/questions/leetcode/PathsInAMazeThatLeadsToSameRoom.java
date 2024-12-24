package questions.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PathsInAMazeThatLeadsToSameRoom {
    public int numberOfPaths(int n, int[][] corridors) {
        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        int cycles = 0;
        for (int[] corridor:  corridors) {
            int room1 = corridor[0];
            int room2 = corridor[1];
            neighbors.putIfAbsent(room1, new HashSet<>());
            neighbors.putIfAbsent(room2, new HashSet<>());
            neighbors.get(room1).add(room2);
            neighbors.get(room2).add(room1);
            cycles += intersectionLength(neighbors.get(room1), neighbors.get(room2));
        }
        return cycles;
    }

    public int intersectionLength(Set<Integer> set1, Set<Integer> set2) {
        int count = 0;
        for (int element: set1) {
            if (set2.contains(element)) {
                count++;
            }
        }
        return count;
    }
}
