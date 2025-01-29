package questions.leetcode.Meta.Trees;

import questions.leetcode.Pair;

public class LowestCommonAncestorWithDeepestNodes {

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


    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }


    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return solve(root).getKey();
    }

    private Pair<TreeNode, Integer> solve(TreeNode node) {
        if (node == null) {
            return new Pair<>(null, 0);
        }

        Pair<TreeNode, Integer> left = solve(node.left);
        Pair<TreeNode, Integer> right = solve(node.right);

        if (left.getValue().equals(right.getValue())) {
            return new Pair<>(node, left.getValue() + 1);
        }

        if (left.getValue() > right.getValue()) {
            return new Pair<>(left.getKey(), left.getValue() + 1);
        }

        return new Pair<>(right.getKey(), right.getValue() + 1);
    }

}
