package questions.leetcode;

import java.util.*;

class TheSkyLineProblem {

    class UnionFind {
        int[] parents;

        UnionFind(int n) {
            parents = new int[n];
            for (int i=0; i<n; i++) {
                parents[i] = i;
            }
        }

        public int find(int v) {
            if (parents[v] != v) {
                return parents[v] = find(parents[v]);
            }
            return v;
        }

        public void union(int v1, int v2) {
            parents[find(v1)] = find(v2);
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        TreeSet<Integer> coordsSet = new TreeSet<>();
        for (int[] building : buildings) {
            coordsSet.add(building[0]);
            coordsSet.add(building[1]);
        }

        List<Integer> coordinates = new ArrayList<>(coordsSet);
        int n = coordinates.size();

        int[] heights = new int[n];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(coordinates.get(i), i);
        }

        Arrays.sort(buildings, (a, b) -> b[2] - a[2]);

        UnionFind uf = new UnionFind(n);
        List<List<Integer>> skyline = new ArrayList<>();

        for (int[] building : buildings) {
            int leftX = building[0];
            int rightX = building[1];
            int height = building[2];
            int left = indexMap.get(leftX);
            int right = indexMap.get(rightX);

            while (left < right) {
                left = uf.find(left);
                if (left < right) {
                    uf.union(left, right);
                    heights[left] = height;
                    left++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == 0 || heights[i] != heights[i - 1]) {
                skyline.add(Arrays.asList(coordinates.get(i), heights[i]));
            }
        }

        return skyline;
    }
}
