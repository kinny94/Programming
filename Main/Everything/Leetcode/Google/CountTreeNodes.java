class CountTreeNodes {
    int count = 0;
    public int countNodes(TreeNode root) {
        if (root != null) {
            count += 1;
            countNodes(root.left);
            countNodes(root.right);
        }
        
        return count;
    }
}