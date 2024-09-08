package datastructures.linkedlist.questions;

public class ReverseALinkedList implements List {

    // this is the head node or root node
    private Node root;
    private int numOfItems;

    public void reverse() {
        Node current = root;
        Node prev = null;
        Node temp = null;
        while(current != null) {
            temp = current.getNextNode();
            current.setNextNode(prev);
            prev = current;
            current = temp;
        }
        root = current;
        // this is where you implement the algorithm !!!

    }

    @Override
    public Node get(int index) {

        int counter = 0;
        Node node = this.root;

        while(node != null) {
            if(index == counter)
                return node;

            counter++;
            node = node.getNextNode();
        }

        return null;
    }

    @Override
    public Node getMiddleNode() {
        return null;
    }

    @Override
    public void insert(int data) {

        if(root==null) {
            // this is the first item in the linked list
            root = new Node(data);
        } else {
            // we know that this is not the first item in the linked list
            insertBeginning(data);
        }
    }

    // we just have to update the references O(1)
    private void insertBeginning(int data) {
        Node newNode = new Node(data);
        newNode.setNextNode(root);
        root = newNode;
    }

    // because we have to start with the root node
    // first we have to find the last node in O(N)
    private void insertEnd(int data, Node node) {

        // this is when we keep looking for the last node O(N)
        if(node.getNextNode() != null) {
            insertEnd(data, node.getNextNode());
        } else {
            // we have found the last node
            Node newNode = new Node(data);
            node.setNextNode(newNode);
        }
    }

    @Override
    public void traverse() {

        if(root==null) return;

        Node actualNode = root;

        while(actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public int size() {
        return numOfItems;
    }
}