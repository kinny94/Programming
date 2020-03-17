/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    
    List<TreeNode> result;
    Set<Integer> toDeleteList;

    
    Solution() {
        this.result = new ArrayList<TreeNode>();
        this.toDeleteList = new HashSet<Integer>();
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i: to_delete) {
            this.toDeleteList.add(i);
        }
        
        helper(root, true);
        return result;
    }
     
    private TreeNode helper(TreeNode node, boolean is_root) {
        if (node == null) return null;
        boolean shouldItemBeDeleted = this.toDeleteList.contains(node.val);
        
        if (is_root && !shouldItemBeDeleted) {
            this.result.add(node);
        }

        node.left = helper(node.left, shouldItemBeDeleted);
        node.right = helper(node.right, shouldItemBeDeleted);

        return shouldItemBeDeleted ? null : node;
    }
}