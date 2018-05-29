class Node{
    
    Node left;
    Node right;
    int data;

    Node( int data ){
        this.data = data;
    }
}

class IsBST{

    public static Node root;

    public static boolean isbst( Node root, Node left , Node right ){
        if( root == null )
            return true;

        if( right != null && root.data < left.data )
            return false;
        
        if( left != null && root.data > right.data )
            return false;

        return isbst(root.left, left, right) && isbst( root.right, left, right);
    }

    public static void main(String[] args) {
        IsBST tree = new IsBST();
        tree.root = new Node(4);
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (tree.isbst(root, root.left, root.right ))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}