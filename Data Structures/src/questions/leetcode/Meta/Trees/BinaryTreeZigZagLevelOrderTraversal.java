package questions.leetcode.Meta.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

public class BinaryTreeZigZagLevelOrderTraversal {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        if (root == null) {
            return results;
        }

        Deque<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        boolean reverse = false;

        while(!dq.isEmpty()) {
            int size = dq.size();
            results.add(new ArrayList<>());

            for (int i=0; i<size; i++) {
                if (!reverse) {
                    TreeNode node = dq.pollFirst();
                    results.get(results.size() - 1).add(node.val);

                    if (node.left != null) {
                        dq.addLast(node.left);
                    }

                    if (node.right != null) {
                        dq.addLast(node.right);
                    }
                } else {
                    TreeNode node = dq.pollLast();
                    results.get(results.size() - 1).add(node.val);

                    if (node.right != null) {
                        dq.addFirst(node.right);
                    }

                    if (node.left != null) {
                        dq.addFirst(node.left);
                    }
                }
            }
            reverse = !reverse;
        }
        return results;
    }
}
