package questions.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompleteNessOfABinaryTree {

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

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr != null) {
                queue.add(curr.left);
                queue.add(curr.right);
            } else {
                while (!queue.isEmpty()) {
                    if (queue.poll() != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
