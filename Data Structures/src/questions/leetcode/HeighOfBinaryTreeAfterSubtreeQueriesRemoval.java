package questions.leetcode;

import java.util.*;

public class HeighOfBinaryTreeAfterSubtreeQueriesRemoval {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private Map<Integer, Integer> nodeDepth = new HashMap<>();
    private Map<Integer, Integer> nodeHeight = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {
        dfs(root, 0);
        Map<Integer, List<int[]>> depthGroups = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry: nodeDepth.entrySet()) {
            int value = entry.getKey();
            int depth = entry.getValue();
            depthGroups.computeIfAbsent(depth, k -> new ArrayList<>()).add(new int[]{nodeHeight.get(value), value});
        }

        for (List<int[]> group: depthGroups.values()) {
            Collections.sort(group, (a, b) -> b[0] - a[0]);
            if (group.size() > 2) {
                group.subList(2, group.size()).clear();
            }
        }

        int[] result = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            int q = queries[i];
            int depth = nodeDepth.get(q);
            List<int[]> depthGroup = depthGroups.get(depth);

            if (depthGroup.size() == 1) {
                result[i] = depth - 1;
            } else if (depthGroup.get(0)[1] == q) {
                result[i] = depthGroup.get(1)[0] + depth;
            } else {
                result[i] = depthGroup.get(0)[0] + depth;
            }
        }
        return result;
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            return -1;
        }

        nodeDepth.put(node.val, depth);
        int leftHeight = dfs(node.left, 1 + depth);
        int rightHeight = dfs(node.right, 1 + depth);
        int height = Math.max(leftHeight, rightHeight) + 1;
        nodeHeight.put(node.val, height);
        return height;
    }
}
