package questions.leetcode.Meta.Trees;

public class BinaryTreeMaximumPathSum {

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

    private int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        solve(root);
        return max;
    }

    private int solve(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMax = solve(node.left);
        int rightMax = solve(node.right);

        int leftSubtree = 0;
        int rightSubtree = 0;

        if (leftMax > 0) {
            leftSubtree = leftMax;
        }

        if (rightMax > 0) {
            rightSubtree = rightMax;
        }

        // Next two lines will calculate the max path on a level outside the scope of this fucntion
        int currentPathSum = leftSubtree + rightSubtree + node.val;
        max = Math.max(max, currentPathSum);

        // this is to actually get the path where should it go.
        return node.val + Math.max(leftSubtree, rightSubtree);
    }
}
