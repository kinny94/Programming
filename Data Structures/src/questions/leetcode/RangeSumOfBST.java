package questions.leetcode;

public class RangeSumOfBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        return solve(root, low, high);
    }

    private int solve(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }

        int currentVal = 0;

        if (node.val >= low && node.val <= high) {
            currentVal += node.val;
        }

        int left = solve(node.left, low, high);
        int right = solve(node.right, low, high);

        return currentVal + left + right;

    }
}

