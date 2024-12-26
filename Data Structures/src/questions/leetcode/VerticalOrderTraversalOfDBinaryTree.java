package questions.leetcode;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.AbstractMap;
import java.util.HashMap;

public class VerticalOrderTraversalOfDBinaryTree {

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

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if (root == null) {
            return output;
        }
        Map<Integer, ArrayList<Integer>> nodeList = new HashMap<>();
        Queue<Map.Entry<TreeNode, Integer>> queue = new ArrayDeque<Map.Entry<TreeNode, Integer>>();
        int column = 0;
        queue.offer(new AbstractMap.SimpleEntry<TreeNode, Integer>(root, column));

        int minColumn = 0;
        int maxIndex = 0;

        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            column = p.getValue();

            if (root != null) {
                if (!nodeList.containsKey(column)) {
                    nodeList.put(column, new ArrayList<Integer>());
                }
                nodeList.get(column).add(root.val);
                minColumn = Math.min(minColumn, column);
                maxIndex = Math.max(maxIndex, column);

                queue.offer(new AbstractMap.SimpleEntry<TreeNode, Integer>(root.left, column - 1));
                queue.offer(new AbstractMap.SimpleEntry<TreeNode, Integer>(root.right,  column + 1));

            }
        }

        for (int i= minColumn; i<maxIndex + 1; i++) {
            output.add(nodeList.get(i));
        }

        return output;
    }
}
