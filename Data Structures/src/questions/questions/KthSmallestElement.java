//package questions.questions;
//
//// this is the binary search tree class
//public class KthSmallestElement<T extends Comparable<T>> implements Tree<T> {
//
//
//    @Override
//    public Node<T> getKSmallest(Node<T> node, int k) {
//        // your algorithm here !!!
//        if (node == null) {
//            return null;
//        }
//
//        // getting the left subtree
//        int n = treeSize(node.getLeftChild()) + 1;
//
//        if (n == k) {
//            return node;
//        }
//
//        if (n > k) {
//            return getKSmallest(node.getLeftChild(), k);
//        }
//
//        if (n < k) {
//            return getKSmallest(node.getRightChild(), k - n);
//        }
//
//        return null;
//    }
//
//
//    // calculate the size of a substree with root node 'node'
//    private int treeSize(Node<T> node) {
//        if(node == null) return 0;
//
//        return (treeSize(node.getLeftChild()) + treeSize(node.getRightChild()) + 1);
//    }
//
//    @Override
//    public void insert(T data) {
//
//        if (root == null) {
//            root = new Node<T>(data);
//        } else {
//            insertNode(data, root);
//        }
//    }
//
//    @Override
//    public T getMaxValue() {
//
//        if (root == null)
//            return null;
//
//        return getMax(root);
//    }
//
//    @Override
//    public T getMinValue() {
//
//        if (root == null)
//            return null;
//
//        return getMin(root);
//    }
//
//    @Override
//    public void traversal() {
//        if (root != null) {
//            inOrderTraversal(root);
//        }
//    }
//
//    private void inOrderTraversal(Node<T> node) {
//
//        if (node.getLeftChild() != null)
//            inOrderTraversal(node.getLeftChild());
//
//        System.out.print(node + "  -->  ");
//
//        if (node.getRightChild() != null)
//            inOrderTraversal(node.getRightChild());
//
//    }
//
//    private Node<T> delete(Node<T> node, T data) {
//
//
//        if( node == null ) return node;
//
//        if( data.compareTo(node.getData()) < 0 ) {
//            node.setLeftChild( delete(node.getLeftChild(), data) );
//        } else if ( data.compareTo(node.getData()) > 0 ) {
//            node.setRightChild( delete(node.getRightChild(), data) );
//        } else {
//
//            // we have found the node we want to remove !!!
//            if( node.getLeftChild() == null && node.getRightChild() == null ) {
//                System.out.println("Removing a leaf node...");
//                return null;
//            }
//
//            if( node.getLeftChild() == null ) {
//                System.out.println("Removing the right child...");
//                Node<T> tempNode = node.getRightChild();
//                node = null;
//                return tempNode;
//            } else if( node.getRightChild() == null ) {
//                System.out.println("Removing the left child...");
//                Node<T> tempNode = node.getLeftChild();
//                node = null;
//                return tempNode;
//            }
//
//            // this is the node with two children case !!!
//            System.out.println("Removing item with two children...");
//            Node<T> tempNode = getPredecessor(node.getLeftChild());
//
//            node.setData(tempNode.getData());
//            node.setLeftChild( delete(node.getLeftChild(), tempNode.getData()) );
//
//        }
//
//        return node;
//    }
//
//    private Node<T> getPredecessor(Node<T> node) {
//
//        if( node.getRightChild() != null )
//            return getPredecessor(node.getRightChild());
//
//        System.out.println("Predecessor is: "+node);
//        return node;
//    }
//
//    private void insertNode(T newData, Node<T> node) {
//
//        if (newData.compareTo(node.getData()) < 0) {
//            if (node.getLeftChild() != null) {
//                insertNode(newData, node.getLeftChild());
//            } else {
//                Node<T> newNode = new Node<T>(newData);
//                node.setLeftChild(newNode);
//            }
//        } else {
//            if (node.getRightChild() != null) {
//                insertNode(newData, node.getRightChild());
//            } else {
//                Node2<T> newNode = new Node2<T>(newData);
//                node.setRightChild(newNode);
//            }
//        }
//    }
//
//    private T getMax(Node<T> node) {
//
//        if (node.getRightChild() != null) {
//            return getMax(node.getRightChild());
//        }
//
//        return node.getData();
//    }
//
//    private T getMin(Node2<T> node) {
//
//        if (node.getLeftChild() != null) {
//            return getMin(node.getLeftChild());
//        }
//
//        return node.getData();
//    }
//
//    @Override
//    public void delete(T data) {
//
//        if (root != null)
//            root = delete(root, data);
//    }
//
//    @Override
//    public Node<T> getRoot() {
//        return root;
//    }
//
//
