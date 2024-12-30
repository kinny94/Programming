package questions.leetcode;

import java.util.HashMap;
import java.util.Map;


class LongestConsecutiveSequence {

    class UnionFind {
        public Map<Integer, Integer> parent;
        public Map<Integer, Integer> rank;
        int maxLength;

        UnionFind(int[] nums) {
            parent = new HashMap<>();
            rank = new HashMap<>();
            maxLength = 1;

            for (int num: nums) {
                parent.put(num, num);
                rank.put(num, 1);
            }
        }

        public int find(int v) {
            if (parent.get(v) != v) {
                parent.put(v, find(parent.get(v)));
            }
            return parent.get(v);
        }

        public void union(int v1, int v2) {
            int p1 = parent.get(v1);
            int p2 = parent.get(v2) ;

            if (p1 != p2) {
                if (rank.get(p1) < rank.get(p2)) {
                    int temp = p1;
                    p1 = p2;
                    p2 = temp;
                }
            }

            parent.put(p2, p1);
            rank.put(p1, rank.get(p1) + rank.get(p2));
            maxLength = Math.max(maxLength, rank.get(p1));
        }
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        UnionFind union = new UnionFind(nums);

        for (int num: nums) {
            if (union.parent.containsKey(num + 1)) {
                union.union(num, num + 1);
            }
        }
        return union.maxLength;
    }
}