package questions.leetcode.Meta.Graph;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {

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

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, null, graph);

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (distance == k) {
                while(!queue.isEmpty()) {
                    result.add(queue.poll().val);
                }
                return result;
            }

            for (int i=0; i<size; i++) {
                TreeNode curr = queue.poll();
                for (TreeNode neighbor: graph.get(curr)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            distance++;
        }
        return result;
    }

    private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if (node == null) {
            return;
        }

        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
        }

        if (parent != null) {
            graph.get(node).add(parent);
            graph.get(parent).add(node);
        }

        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
}
