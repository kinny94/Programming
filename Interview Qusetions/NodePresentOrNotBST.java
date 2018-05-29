class Node{
    
    Node left;
    Node right;
    int data;

    Node( int data ){
        this.data = data;
    }

}

class NodePresentOrNotBST{

    public static boolean isPresent(Node root, int data ){
        if( root != null ){
            if( root.data == data ){
                return true;
            }else{
                return isPresent( root.left, data ) || isPresent( root.right, data ); 
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        System.out.println("Does 4 exist in the tree: " + isPresent(root, 4));
        System.out.println("Does 7 exist in the tree: " + isPresent(root, 7));
        
    }
}