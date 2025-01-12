package questions.leetcode;

public class LowestCommonAncestorOfABinaryTree {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root, p, q);
    }

    public TreeNode solve(TreeNode node, TreeNode p, TreeNode q)  {
        if (node == null) {
            return null;
        }

        if (node == p || node == q) {
            return node;
        }

        TreeNode left = solve(node.left, p, q);
        TreeNode right = solve(node.right, p, q);

        if (left != null && right != null) {
            return node;
        }

        if (left != null) {
            return left;
        }

        return right;
    }
}
