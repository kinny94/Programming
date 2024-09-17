package leetcode.binarysearchtrees;

class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return hasPath(root, targetSum);
    }

    private boolean hasPath(TreeNode node, int target) {
        if (node != null && node.left == null && node.right == null && (target - node.val) != 0) {
            return false;
        }

        if (node == null) {
            return false;
        }


        if (node.left == null && node.right == null && (target - node.val) == 0) {
            return true;
        }


        return hasPath(node.left, target - node.val) || hasPath(node.right, target - node.val);

    }
}