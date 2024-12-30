package questions.leetcode;

class RegionsCutBySlashes {

    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i=0; i<n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int v) {
            if (parent[v] != v) {
                parent[v] = find(parent[v]);
            }
            return parent[v];
        }

        public void union(int v1, int v2) {
            int p1 = find(v1);
            int p2 = find(v2);
            if (p1 != p2) {
                if (rank[p1] > rank[p2]) {
                    parent[p2] = p1;
                    rank[p1] = p1;
                } else {
                    parent[p1] = p2;
                    rank[p2] += rank[p1];
                }
            }
        }
    }

    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        UnionFind findUnion= new UnionFind(4 * N * N);

        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {

                int root = 4 * (r * N + c);
                char val = grid[r].charAt(c);

                if ((val == '/') || (val == ' ')) {
                    findUnion.union(root + 0, root + 1);
                    findUnion.union(root + 2, root + 3);
                }
                if ((val == '\\') || (val == ' ')) {
                    findUnion.union(root + 0, root + 2);
                    findUnion.union(root + 1, root + 3);
                }
                if (r + 1 < N)
                    findUnion.union(root + 3, (root + 4 * N) + 0);

                if (r - 1 >= 0)
                    findUnion.union(root + 0, (root - 4 * N) + 3);

                if (c + 1 < N)
                    findUnion.union(root + 2, (root + 4) + 1);

                if (c - 1 >= 0)
                    findUnion.union(root + 1, (root - 4) + 2);
            }
        }

        int count = 0;
        for (int x = 0; x < 4 * N * N; ++x) {
            if (findUnion.find(x) == x)
                count++;
        }

        return count;
    }
}
