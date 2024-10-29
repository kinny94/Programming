//package questions.questions;
//
//public class CompareTree<T extends Comparable<T>> {
//
//    public boolean isTreeSame(Node2<T> node1, Node2<T> node2) {
//
//        // we have access to the root nodes (node1 and node2) of the binary search trees
//        // your algorithm here !!!
//        if ((node1 == null && node2 == null) || (node1 == null && node2 != null ) || (node1 != null && node2 == null)) {
//            return node1 == node2;
//        }
//
//        if (node1.getData().compareTo(node2.getData()) != 0) {
//            return false;
//        }
//
//        isTreeSame(node1.getLeftChild(), node2.getLeftChild());
//        isTreeSame(node2.getRightChild(), node2.getRightChild());
//
//        return true;
//    }
//
//}
//
//class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
//
//    private Node2<T> root;
//
//    @Override
//    public void insert(T data) {
//
//        if (root == null) {
//            root = new Node2<T>(data);
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
//    private void inOrderTraversal(Node2<T> node) {
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
//    private Node2<T> delete(Node2<T> node, T data) {
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
//                Node2<T> tempNode = node.getRightChild();
//                node = null;
//                return tempNode;
//            } else if( node.getRightChild() == null ) {
//                System.out.println("Removing the left child...");
//                Node2<T> tempNode = node.getLeftChild();
//                node = null;
//                return tempNode;
//            }
//
//            // this is the node with two children case !!!
//            System.out.println("Removing item with two children...");
//            Node2<T> tempNode = getPredecessor(node.getLeftChild());
//
//            node.setData(tempNode.getData());
//            node.setLeftChild( delete(node.getLeftChild(), tempNode.getData()) );
//
//        }
//
//        return node;
//    }
//
//    private Node2<T> getPredecessor(Node2<T> node) {
//
//        if( node.getRightChild() != null )
//            return getPredecessor(node.getRightChild());
//
//        System.out.println("Predecessor is: "+node);
//        return node;
//    }
//
//    private void insertNode(T newData, Node2<T> node) {
//
//        if (newData.compareTo(node.getData()) < 0) {
//            if (node.getLeftChild() != null) {
//                insertNode(newData, node.getLeftChild());
//            } else {
//                Node2<T> newNode = new Node2<T>(newData);
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
//    private T getMax(Node2<T> node) {
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
//    public Node2<T> getRoot() {
//        return root;
//    }
//
//}
//
//class Node<T> {
//
//    private T data;
//    private Node2<T> leftChild;
//    private Node2<T> rightChild;
//
//    public Node(T data) {
//        this.data = data;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    public Node2<T> getLeftChild() {
//        return leftChild;
//    }
//
//    public void setLeftChild(Node2<T> leftChild) {
//        this.leftChild = leftChild;
//    }
//
//    public Node2<T> getRightChild() {
//        return rightChild;
//    }
//
//    public void setRightChild(Node2<T> rightChild) {
//        this.rightChild = rightChild;
//    }
//
//    @Override
//    public String toString() {
//        return this.data.toString();
//    }
//}
//
//interface Tree<T> {
//    public Node2<T> getRoot();
//    public void traversal();
//    public void insert(T data);
//    public void delete(T data);
//    public T getMaxValue();
//    public T getMinValue();
//}