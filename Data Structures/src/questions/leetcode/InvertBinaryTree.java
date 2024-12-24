package questions.leetcode;

public class InvertBinaryTree {

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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        if (root.right != null) {
            invertTree(root.right);
        }

        if (root.left != null) {
            invertTree(root.left);
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
