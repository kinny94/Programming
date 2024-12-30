package questions.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostStonesRemovedWithSameRowColumn {
    class UnionFind {
        private Map<Integer, Integer> parents;
        private Map<Integer, Integer> ranks;

        public UnionFind() {
            parents = new HashMap<>();
            ranks = new HashMap<>();
        }

        public int find(int coordinate) {
            if (coordinate != parents.get(coordinate)) {
                parents.put(coordinate, find(parents.get(coordinate)));
            }
            return parents.get(coordinate);
        }

        public void union(int x, int y) {
            parents.putIfAbsent(x, x);
            parents.putIfAbsent(y, y);

            ranks.putIfAbsent(x, 0);
            ranks.putIfAbsent(y, 0);

            if (ranks.get(x) > ranks.get(y)) {
                parents.put(find(y), find(x));
            } else if (ranks.get(y) > ranks.get(x)) {
                parents.put(find(x), find(y));
            } else {
                parents.put(find(x), find(y));
                ranks.put(y, ranks.get(y) + 1);
            }
        }

        public Map<Integer, Integer> getParents() {
            return parents;
        }
    }
    class Solution {
        public int removeStones(int[][] stones) {
            int offset = 100000;
            UnionFind stone = new UnionFind();
            for (int[] s: stones) {
                int x = s[0];
                int y = s[1];
                stone.union(x, y + offset);
            }

            Set<Integer> groups = new HashSet<>();
            Map<Integer, Integer> parents = stone.getParents();
            for (Map.Entry<Integer, Integer> entry: parents.entrySet()) {
                groups.add(stone.find(entry.getKey()));
            }

            return stones.length - groups.size();
        }
    }
}
