/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BTFlipEquivalent {
  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
      
      if (root1 == null && root2 == null) return true;
      if (root1 == null || root2 == null) return false;
      
      if (root1.val != root2.val) {
          System.out.println("comparing root1 " + root1.val + "and " + root2.val);
          return false;
      };
      
      // not flip childen
      boolean v1 = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
      // flip childen
      boolean v2= flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
      
          
      return v1 || v2;
  }
}