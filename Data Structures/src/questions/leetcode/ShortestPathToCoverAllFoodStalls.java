package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathToCoverAllFoodStalls {
    static class TreeNode {
        int val;
        List<TreeNode> children;

        public TreeNode(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    public static int shortestPath(TreeNode root) {
        if (root == null) return 0;
        return dfs(root);
    }

    private static int dfs(TreeNode node) {

        int totalPath = 0;

        for (TreeNode child : node.children) {
            totalPath += dfs(child); // Get the path from the child
            totalPath += 2; // Add the round trip cost to this child
        }

        return totalPath;
    }


    // Example usage
    public static void main(String[] args) {
        // Create the tree structure:
        TreeNode root = new TreeNode(1);

        TreeNode node2 = new TreeNode(2); // Food stall
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4); // Food stall
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6); // Food stall
        TreeNode node7 = new TreeNode(7); // Food stall
        TreeNode node8 = new TreeNode(8); // Food stall

        // Build the tree:
        root.children.add(node2); // 1 -> 2
        root.children.add(node3); // 1 -> 3
        root.children.add(node4); // 1 -> 4

        node2.children.add(node5); // 2 -> 5
        node3.children.add(node6); // 3 -> 6
        node4.children.add(node7); // 4 -> 7
        node5.children.add(node8); // 5 -> 8

        // Call the shortestPath function
        int result = shortestPath(root);
        System.out.println("Shortest Path to visit all food stalls: " + result); // Expected: 12
    }
}
