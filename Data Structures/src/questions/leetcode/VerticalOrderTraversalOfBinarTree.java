package questions.leetcode;

import java.util.*;

public class VerticalOrderTraversalOfBinarTree {

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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // Map to store column index -> list of (row, value) pairs
        Map<Integer, PriorityQueue<Pair<Integer, Integer>>> columnMap = new HashMap<>();
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> queue = new LinkedList<>();

        // Initialize BFS with root at (row = 0, column = 0)
        queue.add(new Pair<>(root, new Pair<>(0, 0)));
        int minColumn = 0;
        int maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Pair<Integer, Integer>> curr = queue.poll();
            TreeNode node = curr.getKey();
            int row = curr.getValue().getKey();
            int column = curr.getValue().getValue();

            // Add the current node to the map
            columnMap.putIfAbsent(column, new PriorityQueue<>(
                    (a, b) -> a.getKey().equals(b.getKey())
                            ? Integer.compare(a.getValue(), b.getValue()) // Sort by value if rows are the same
                            : Integer.compare(a.getKey(), b.getKey())     // Sort by row
            ));
            columnMap.get(column).add(new Pair<>(row, node.val));

            // Update column bounds
            minColumn = Math.min(minColumn, column);
            maxColumn = Math.max(maxColumn, column);

            // Add child nodes to the queue
            if (node.left != null) {
                queue.add(new Pair<>(node.left, new Pair<>(row + 1, column - 1)));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, new Pair<>(row + 1, column + 1)));
            }
        }

        // Prepare the result
        for (int i = minColumn; i <= maxColumn; i++) {
            PriorityQueue<Pair<Integer, Integer>> pq = columnMap.get(i);
            List<Integer> columnValues = new ArrayList<>();
            while (!pq.isEmpty()) {
                columnValues.add(pq.poll().getValue());
            }
            result.add(columnValues);
        }

        return result;
    }
}
