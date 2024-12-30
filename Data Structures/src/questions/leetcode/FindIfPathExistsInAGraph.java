package questions.leetcode;

class FindIfPathExistsInAGraph {

    class UnionFind {
        int[] parents;
        int[] rank;

        UnionFind(int n) {
            parents = new int[n];
            rank = new int[n];
            for (int i=0; i<n; i++) {
                parents[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int v) {
            if (parents[v] != v) {
                return parents[v] = find(parents[v]);
            }
            return v;
        }

        public void union(int v1, int v2) {
            int p1 = find(v1);
            int p2 = find(v2);

            if (p1 != p2) {
                if (rank[p1] > rank[p2]) {
                    parents[p2] = p1;
                } else if (rank[p1] < rank[p2]) {
                    parents[p1] = p2;
                } else {
                    parents[p2] = p1;
                    rank[p1]++;
                }
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge: edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.find(source) == uf.find(destination);
    }
}
