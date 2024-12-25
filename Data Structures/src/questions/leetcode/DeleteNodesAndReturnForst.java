package questions.leetcode;

import java.util.Arrays;
import java.util.List
public class DeleteNodesAndReturnForst {

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

    public boolean deleteNodes(TreeNode root, List<TreeNode> list, int[] to_delete) {
        if (root == null)
            return true;

        boolean deleteLeft = deleteNodes(root.left, list, to_delete);
        boolean deleteRight = deleteNodes(root.right, list, to_delete);
        boolean deleteThis = Arrays.binarySearch(to_delete, root.val) >= 0;
        if (deleteThis) {
            if (root.left != null && !deleteLeft)
                list.add(root.left);
            if (root.right != null && !deleteRight)
                list.add(root.right);
        } else {
            if (deleteLeft)
                root.left = null;
            if (deleteRight)
                root.right = null;
        }
        return deleteThis;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        Arrays.sort(to_delete);
        boolean deleteRoot = deleteNodes(root, list, to_delete);
        if(!deleteRoot) list.add(root);
        return list;
    }
}
