/*
    Ina doublythreaded binary tree each node is threaded towards both the in-order predecessor and succesor( left and right )
    means all right null pointers will point to inorder successor and all left null pointers will point to inorder predecessor.

    Conventions

    LeftBit=0 => left reference points to the inorder predecessor
    leftBit=1 => left reference points to the child
    rightBit=0 => right reference points to the inorder predecessor
    rightBit=1 => right rederence points to the right child
*/
class Node{
    int data;
    int leftBit;
    int rightBit;
    Node left;
    Node right;

    public Node( int data ){
        this.data = data;
    }
}

public class DoubleThreadedBinaryTree{

    public static Node root;
    public static boolean directionLeft;
    public static boolean directionRight;

    public DoubleThreadedBinaryTree(){
            root = new Node( Integer.MAX_VALUE );
            root.leftBit = 0;
            root.rightBit = 1;
            root.left = root.right = root;
    }

    public void insert( int data ){
        Node newNode = new Node( data );
        if( root == root.left && root.right == root ){
            newNode.left = root;
            root.left = newNode;
            newNode.leftBit = root.leftBit;
            root.leftBit = 1;
            newNode.right = root;
        }else{
            Node current = root.left;
            while( true ){
                if( current.data > newNode.data ){
                    if( current.leftBit == 0 ){
                        directionLeft = true;
                        directionRight = false;
                        break;
                    }else{
                        current = current.left;
                    }
                }else{
                    if( current.rightBit == 0 ){
                        directionLeft = false;
                        directionRight = true;
                        break;
                    }else{
                        current = current.right;
                    }
                }
            }
            if( directionLeft ){
                newNode.left = current.left;
                current.left = newNode;
                newNode.leftBit = current.leftBit;
                current.leftBit = 1;
                newNode.right = current;
            }else if( directionRight ){
                newNode.right = current.right;
                current.right = newNode;
                newNode.rightBit = current.rightBit;
                current.rightBit = 1;
                newNode = current;
            }
        }
    }

    public void inorder(){
        Node current = root.left;
        while( current.leftBit == 1 ){
            current = current.left;
        }

        while( current != root ){
            System.out.println(" " + current.data );
            current = findNextInorder( current );
        }
    }

    public Node findNextInorder( Node current ){
        if( current.rightBit == 0 ){
            return current.right;
        }

        current = current.right;
        while( current.leftBit != 0 ){
            current = current.left;
        }

        return current;
    }

    public static void main(String[] args) {
        DoubleThreadedBinaryTree i = new DoubleThreadedBinaryTree();
		i.insert(10);
		i.insert(12);
		i.insert(15);
		i.insert(2);
		i.insert(13);
		i.insert(1);
		i.insert(4);
		i.inorder();
    }
}