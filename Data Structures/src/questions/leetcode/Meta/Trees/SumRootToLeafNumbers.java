package questions.leetcode.Meta.Trees;

public class SumRootToLeafNumbers {

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

    public int sumNumbers(TreeNode root) {
        return solve(root, 0);
    }

    private int solve(TreeNode node, int pathSum) {

        if (node == null) {
            return 0;
        }

        pathSum = pathSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return pathSum;
        }

        int left = solve(node.left , pathSum);
        int right = solve(node.right, pathSum);

        return  left + right;

    }
}
