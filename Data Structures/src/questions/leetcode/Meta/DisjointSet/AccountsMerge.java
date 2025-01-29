package questions.leetcode.Meta.DisjointSet;

import java.util.*;

class AccountsMerge {

    class UnionFind {
        private int[] parents;

        public UnionFind(int n) {
            parents = new int[n];
            for (int i=0; i<n; i++) {
                parents[i] = i;
            }
        }

        public int find(int v) {
            if (parents[v] != v) {
                return find(parents[v]);
            }
            return v;
        }

        public void union(int v1, int v2) {
            int p1 = find(v1);
            int p2 = find(v2);

            if (p1 != p2) {
                parents[p2] = p1;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind ds = new UnionFind(accounts.size());
        Map<String, Integer> emailMapping = new HashMap<>();

        for (int i=0; i<accounts.size(); i++) {
            List<String> emails = accounts.get(i);
            for (int j=1; j<emails.size(); j++) {
                if (emailMapping.containsKey(emails.get(j))) {
                    String userName = accounts.get(i).get(0);
                    int currentUserId = emailMapping.get(emails.get(j));
                    String currentUserName = accounts.get(currentUserId).get(0);
                    if (!userName.equals(currentUserName)) {
                        return new ArrayList<>();
                    }
                    ds.union(emailMapping.get(emails.get(j)), i);

                }
                emailMapping.put(emails.get(j), i);
            }
        }

        Map<Integer, List<String>> mergedAccounts = new HashMap<>();
        for (Map.Entry<String, Integer> entry: emailMapping.entrySet()) {
            int root = ds.find(entry.getValue());
            mergedAccounts.putIfAbsent(root, new ArrayList<>());
            mergedAccounts.get(root).add(entry.getKey());
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry: mergedAccounts.entrySet()) {
            int parent = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(parent).get(0));
            merged.addAll(emails);
            result.add(merged);
        }
        return result;
    }
}
