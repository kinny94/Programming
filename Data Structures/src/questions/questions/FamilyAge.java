//package questions.questions;
//
//// this is the binary search tree itself
//public class FamilyAge<T extends Comparable<T>> implements Tree<T> {
//
//    private Node<T> root;
//
//    @Override
//    public int getTotalAge(Node<T> node) {
//
//        // this is where you implement the algorithm
//        // and returns with the total sum of age values
//        return getSum(node);
//
//    }
//
//    private int getSum(Node<T> node) {
//        if (node == null) {
//            return 0;
//        }
//
//        return (int) ((Person)node.getData()).getAge() + getSum(node.getLeftChild()) + getSum(node.getRightChild());
//
//    }
//
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
//                Node<T> newNode = new Node<T>(newData);
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
//    private T getMin(Node<T> node) {
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
//}
//
//class Person implements Comparable<Person> {
//
//    private String name;
//    private int age;
//
//    public Person(String name, int age) {
//        this.age = age;
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public int compareTo(Person person) {
//        return -(age - person.getAge());
//    }
//
//    @Override
//    public String toString() {
//        return this.name + "-" + this.age;
//    }
//}
//
//interface Tree<T> {
//    public int getTotalAge(Node<T> node);
//    public Node<T> getRoot();
//    public void traversal();
//    public void insert(T data);
//    public void delete(T data);
//    public T getMaxValue();
//    public T getMinValue();
//}