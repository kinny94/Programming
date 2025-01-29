package questions.leetcode.Meta.Trees;

public class ClosestBinarySearchTreevalue {

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

    public int closestValue(TreeNode root, double target) {

        TreeNode node = root;
        int closest = root.val;
        while(node != null) {
            if (Math.abs(node.val - target) < Math.abs(closest - target)) {
                closest = node.val;
            }

            if ((Math.abs(node.val - target) == Math.abs(closest - target)&& node.val < closest)) {
                closest = node.val;
            }

            node = target < node.val ? node.left : node.right;
        }
        return closest;
    }
}
