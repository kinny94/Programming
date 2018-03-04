/*

    APPROACH
    Operations:
        Insert(int n) : Add a node the tree with value n. Its O(lgn)
        Find(int n) : Find a node the tree with value n. Its O(lgn)
        Delete (int n) : Delete a node the tree with value n. Its O(lgn)=
        Display(): Prints the entire tree in increasing order. O(n).
        Detail Explanations for the Operations:

    
    DELETE: Complicated than Find() and Insert() operations. Here we have to deal with 3 cases.
        Node to be deleted is a leaf node ( No Children).
        Node to be deleted has only one child.
        Node to be deleted has two childrens.
        Node to be deleted is a leaf node ( No Children).
        its a very simple case, if a node to be deleted has no children then just traverse to that node, keep track of parent node 
        and the side in which the node exist(left or right) and set parent.left = null or parent.right = null;

        Node to be deleted has only one child.

            its a slightly complex case. if a node to be deleted(deleteNode) has only one child then just traverse to that node, 
            keep track of parent node and the side in which the node exist(left or right). check which side 
            child is null (since it has only one child).
            Say node to be deleted has child on its left side . Then take the entire sub tree from the left side and add it to 
            the parent and the side on which deleteNode exist

*/

class Node{
    int data;
    Node left;
    Node right;

    public Node( int data ){
        this.data = data;
        left = null;
        right = null;
    }
}

class BinarySearchTree{
    public  static Node root;
    public BinarySearchTree(){
        this.root = null;
    }

    public boolean find( int id ){
        Node current = root;
        while( current != null ){
            if( current.data == id ){
                return true;
            }else if( current.data > id ){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return false;
    }

    public boolean delete( int id ){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;

        while( current.data != id ){
            parent = current;
            if( current.data > id ){
                isLeftChild = true;
                current = current.left;
            }else{
                isLeftChild = false;
                current = current.right;
            }

            if( current == null ){
                return false;
            }
        }

        if( current.left == null && current.right == null ){
            if( current == root ){
                root = null;
            }

            if( isLeftChild == true ){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }else if( current.right == null ){
            if( current == root ){
                root = current.left;
            }else if( isLeftChild ){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }else if( current.left == null && current.right != null ){
            Node successor = getSuccessoNode( current );
            if( current == root ){
                root = successor;
            }else if( isLeftChild ){
                parent.left = successor;
            }else{
                parent.right = successor;
            }

            successor.left = current.left;
        }
        return true;
    }

    public Node getSuccessoNode( Node deleteNode ){
        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.right;

        while( current != null ){
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if( successor != deleteNode.right ){
            successorParent.left = successor.right;
            successor.right = deleteNode.right;
        }

        return successor;
    }

    public void insert( int id ){
        Node newNode = new Node( id );
        if( root == null ){
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;
        while( true ){
            parent = current;
            if( id < current.data ){
                current = current.left;
                if( current == null ){
                    parent.left = newNode;
                    return;
                }   
            }else{
                current = current.right;
                if( current == null ){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public void display( Node root ){
        if( root != null ){
            display( root.left );
            System.out.print(" " + root.data );
            display( root.right );
        }
    }

    public static void main(String arg[]){
		BinarySearchTree b = new BinarySearchTree();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println("Original Tree : ");
		b.display(b.root);		
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		b.display(root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.display(root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.display(root);
	}

}