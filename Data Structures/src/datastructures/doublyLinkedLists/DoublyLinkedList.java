package datastructures.doublyLinkedLists;

public class DoublyLinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> tail;

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        // this is the first item in the list
        if (tail == null) {
            // both of the pointers are pointing to the new node
            tail = newNode;
            head = newNode;
        } else {
            newNode.setPreviousNode(tail);
            tail.setNextNode(newNode);
            tail = newNode;
        }
    }

    public void traverseForward() {
        Node<T> actualNode = head;

        while (actualNode != null) {
            System.out.print(actualNode);
            actualNode = actualNode.getNextNode();
        }
    }

    public void traverseBackward() {
        Node<T> actualNode = tail;

        while (actualNode != null) {
            System.out.print(actualNode);
            actualNode = actualNode.getPreviousNode();
        }
    }
}
