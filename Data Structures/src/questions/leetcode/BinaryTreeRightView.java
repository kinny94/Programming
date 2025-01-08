package questions.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightView {

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

    public List<Integer> rightSideViewWithBfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                size--;
                TreeNode curr = queue.poll();
                if (size == 0) {
                    result.add(curr.val);
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }

            }
        }
        return result;

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        solve(root, 0, result);
        return result;
    }

    public void solve(TreeNode node, int level, List<Integer> result) {
        if (result.size() == level) {
            result.add(node.val);
        }

        if(node.right != null) {
            solve(node.right, level + 1, result);
        }

        if (node.left != null) {
            solve(node.left, level + 1, result);
        }
    }
}
