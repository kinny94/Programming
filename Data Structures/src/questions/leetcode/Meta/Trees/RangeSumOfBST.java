package questions.leetcode.Meta.Trees;

import java.util.LinkedList;
import java.util.Queue;

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

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.val >= low && curr.val <= high) {
                sum += curr.val;
            }

            if (curr.val > low && curr.left != null) {
                queue.add(curr.left);
            }


            if (curr.val < high && curr.right != null) {
                queue.add(curr.right);
            }
        }
        return sum;
    }
}

