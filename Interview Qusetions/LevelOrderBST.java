import java.util.*;

class Node{
    int data;
    Node left;
    Node right;

    Node( int data ){
        this.data = data;
    }
}

class LevelOrderBST{

    public int height( Node root ){
        if( root == null ){
            return 0;
        }

        return 1 + Math.max( height( root.left ), height( root.right ));
    }

    public void printLevels( Node root, int h ){
        if( root == null ) return;
        if( h == 1 ) System.out.println(" " + root.data );
        else{
            printLevels(root.left, h-1);
            printLevels(root.right, h-1);
        }
    }

    public void levelOrderNaiveApproach( Node root ){
        int h = height( root );
        for( int i=1; i<=h; i++ ){
            printLevels(root, i);
            System.out.println("");
        }
    }


    public void queueApproach( Node root ){
        Queue q = new LinkedList();
        int levelNodes = 0;
        if ( root == null ) return;

        q.add( root );
        while ( !q.isEmpty() ){
            levelNodes = q.size();
            while( levelNodes > 0 ){
                Node n = ( Node )q.remove();
                System.out.println( " " + n.data );
                
                if( n.left != null ) q.add( n.left );
                if( n.right != null ) q.add( n.right );

                levelNodes--;
            }
            
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		
		LevelOrderBST i  = new LevelOrderBST();
		System.out.println(" Output by Naive Approach : ");
		i.levelOrderNaiveApproach(root);

        System.out.println(" Output by Better Approach : ");
		i.queueApproach(root);
    }
}