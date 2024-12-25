package questions.leetcode;

public class MaximumDepthOfABinaryTree {

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

    public int maxDepth(TreeNode root) {
        return getDepth(root);
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0; // Base case: return 0 for null nodes
        }

        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        return 1 + Math.max(leftDepth, rightDepth); // Add 1 for the current node
    }
}
