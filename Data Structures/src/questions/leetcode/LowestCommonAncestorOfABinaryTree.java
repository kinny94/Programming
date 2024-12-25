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

    private TreeNode lca;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        solve(root, p, q);
        return lca;
    }

    private boolean solve(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }

        boolean mid = false;
        boolean left = false;
        boolean right = false;

        if (p.val == node.val || node.val == q.val) {
            mid = true;
        }

        left = solve(node.left, p, q);

        if (lca == null) {
            right = solve(node.right, p, q);
        }

        if (boolToInt(mid) + boolToInt(left) + boolToInt(right) >= 2) {
            lca = node;
        }

        return mid || left || right;

    }

    private int boolToInt(boolean value) {
        return value ? 1 : 0;
    }
}
