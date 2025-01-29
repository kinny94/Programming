package questions.leetcode.Meta.Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        solve(root, "", paths);
        return paths;
    }

    public void solve(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            path += root.val;

            if (root.left == null && root.right == null) {
                paths.add(path);
            } else {
                path += "->";
                solve(root.left, path, paths);
                solve(root.right, path, paths);
            }
        }
    }
}
