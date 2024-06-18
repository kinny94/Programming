package datastructures.LinkedLists;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int numOfItems;

    public Node<T> getMiddleNode() {
        Node<T> slowPoiner = root;
        Node<T> fastPointer = root;

        while (fastPointer.getNextNode() != null && fastPointer.getNextNode().getNextNode() != null) {
            slowPoiner = slowPoiner.getNextNode();
            fastPointer = fastPointer.getNextNode().getNextNode();
        }
        return slowPoiner;
    }


    public void reverse() {
        Node<T> currentNode = this.root;
        Node<T> nextNode = null;
        Node<T> previousNode = null;

        while (currentNode != null) {
            nextNode = currentNode.getNextNode();
            currentNode.setNextNode(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }
        this.root = previousNode;
    }

    @Override
    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            insertBeginning(data);
        }
    }

    private void insertBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        root = newNode;
    }

    private void insertEnd(T data, Node<T> node) {
        if (node.getNextNode() != null) {
           insertEnd(data, node.getNextNode());
        } else {
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);
        }
    }

    @Override
    public void remove(T data) {
        if (root == null) {
            return;
        }

        if (root.getData().compareTo(data)==0) {
            root = root.getNextNode();
        } else {
            remove(data, root, root.getNextNode());
        }
    }

    public void remove(T data, Node<T> previousNode, Node<T> actualNode) {
        while (actualNode != null) {
            if (actualNode.getData().compareTo(data) == 0)  {
                numOfItems--;
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }
            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void traverse() {
        if (root == null) {
            return;
        }
         Node<T> actualNode = root;
        while (actualNode != null) {
            System.out.print(actualNode);
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public int size() {
        return numOfItems;
    }
}
