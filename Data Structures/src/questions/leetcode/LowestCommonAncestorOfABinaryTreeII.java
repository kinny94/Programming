package questions.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorOfABinaryTreeII {

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
        Set<Integer> found = new HashSet<>();
        TreeNode node = solve(root, p, q, found);
        return found.size() == 2 ? node : null;
    }

    private TreeNode solve(TreeNode node, TreeNode p, TreeNode q, Set<Integer> found) {
        if (node == null) {
            return null;
        }

        TreeNode left = solve(node.left, p, q, found);
        TreeNode right = solve(node.right, p, q, found);

        if (node.val == p.val || node.val == q.val) {
            found.add(node.val);
            return node;
        }

        if (left != null && right != null) {
            return node;
        }

        if (left == null) {
            return right;
        }

        return left;
    }
}
