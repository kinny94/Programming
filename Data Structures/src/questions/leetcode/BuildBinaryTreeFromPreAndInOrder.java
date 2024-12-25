package questions.leetcode;

import java.util.HashMap;

public class BuildBinaryTreeFromPreAndInOrder {
    private int index;

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> mapping = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            mapping.put(inorder[i], i);
        }
        index = 0;
        return solve(preorder, inorder, 0, preorder.length - 1, mapping);
    }

    private TreeNode solve(int[] preorder, int[] inorder, int low, int high, HashMap<Integer, Integer> mapping) {
        if (low > high) {
            return null;
        }

        int curr = preorder[index];
        index++;
        TreeNode root = new TreeNode(curr);

        if (low == high) {
            return root;
        }

        int inIndex = mapping.get(curr);

        root.left = solve(preorder, inorder, low, inIndex - 1, mapping);
        root.right = solve(preorder, inorder, inIndex + 1, high, mapping);
        return root;
    }
}
