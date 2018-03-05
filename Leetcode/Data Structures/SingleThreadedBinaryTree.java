/*
    Single Threaded: each node is threaded towards either the in-order predecessor or successor (left or right) 
    means all right null pointers will point to inorder successor OR all left null pointers will point to inorder predecessor.
*/
class Node{
    Node left;
    Node right;
    int data;
    boolean rightThread;

    public Node( int data ){
        this.data = data;
        rightThread = false;
    }
}

class SingleThreadedBinaryTree{
    public static Node root;

    public void insert( Node root, int id ){
        Node newNode = new Node( id );
        Node current = root;
        Node parent = null;

        while( true ){
            parent = current;
            if( id< current.data ){
                current = current.left;
                if( current == null ){
                    parent.left = newNode;
                    newNode.right = parent;
                    newNode.rightThread = true;
                    return;
                }
            }else{
                if( current.rightThread == false ){
                    current = current.right;
                    if( current == null ){
                        parent.right = newNode;
                        return;
                    }
                }else{
                    if( current.rightThread == false ){
                        current = current.right;
                        if( current == null ){
                            parent.right = newNode;
                            return;
                        }
                    }else{
                        Node temp = current.right;
                        current.right = newNode;
                        newNode.right = temp;
                        newNode.rightThread = true;
                        return;
                    }
                }
            }
        }
    }

    public void print( Node root ){
        Node current = leftMostNode( root );

        while( current != null ){
            System.out.println(" " + current.data );
            if( current.rightThread ){
                current = current.right;
            }else{
                current = leftMostNode( current.right );
            }
        }
        System.out.println();
    }

    public Node leftMostNode( Node node ){
        if( node == null ){
            return null;
        }else{
            while( node.left != null ){
                node = node.left;
            }
            return node;
        }
    }

    public static void main(String[] args) {
        root = new Node(100);
        SingleThreadedBinaryTree st=new SingleThreadedBinaryTree();
        st.insert(root,50);
        st.insert(root,25);
        st.insert(root,7);
        st.insert(root,20);
        st.insert(root,75);
        st.insert(root,99);

        st.print(root);
    }
}