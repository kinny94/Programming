package questions.leetcode;

import java.util.Stack;

public class BSTIterator {
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

    Stack<TreeNode> stack;
    TreeNode node;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.node = root;
    }

    public int next() {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }

        node = stack.pop();
        int res = node.val;
        node = node.right;
        return res;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || node != null;
    }
}
