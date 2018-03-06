/*
    AVL tree is widely known as self-balancing binary search tree. In AVL trees, the heights of the child subtrees at any node
    differ by at most 1. If the height difference becomes greater than 1, then the tree balancing is done to restore its property.
    Search, Insertion and deletion, all operations takes O(logn) time since the tree is balanced.

    Question: Why AVL tree is better than binary search tree?
    Ans: Average time complexity in binary search tree for any operation takes O(logn) time but there are times when your 
    tree is skewed. In those cases the operations on them takes O(n) time but in AVL Tree, since it is always balanced, 
    it always takes O(logn) time.

    Q. How Tree balance itself?
    A. There are two basic operations, using which tree balance itself.
    * Left Rotation
    * Right rotation

    Q. How these rotations works?
    A. Let 'A' be the new node added to the tree.
    * Once 'A' is added, start travelling up from 'A' to the root and find the unbalanced node, balance it and again keep travelling
    up.
    * Say you have found the node 'Z' which is unbalanced.
    * Node y is the child of 'Z' and 'X' be the grandchild of Z.

    Then there will be four possibilites:-
        Left-Left Case : – x is the left child of y and y is the left child of z.
        Left-Right Case : – x is the right child of y and y is the left child of z.
        Right-Left Case : – x is the left child of y and y is the right child of z.
        Right-Right Case : – x is the right child of y and y is the right child of z.
*/

public class Node{
    int data;
    Node left;
    Node right;
    int height;

    public Node( int data ){
        this.data = data;
        height = 1;
    }
}