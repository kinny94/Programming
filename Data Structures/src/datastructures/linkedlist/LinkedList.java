package datastructures.linkedlist;

class Node<T> {

    private T data;
    private Node nextNode;

    public Node(T data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public T getData() {
        return data;
    }
}

public class LinkedList<T> {

    private Node head;

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printLinkedList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNextNode();
        }
        System.out.println();
    }

    public void insertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.setNextNode(head);
            head = newNode;
        }
    }

    public void insertAtEnd(T data) {
        if (isEmpty()) {
            insertAtBeginning(data);
        }
        Node<T> current = head;
        while (current.getNextNode() != null) {
            current = current.getNextNode();
        }
        Node newNode = new Node<>(data);
        current.setNextNode(newNode);
    }

    public T remove(T data) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }

        if (head.getData().equals(data)) {
            T removedData = (T) head.getData();
            head = head.getNextNode();
            return removedData;
        }

        Node<T> current = head;
        Node<T> previous = null;

        while (current != null && !current.getData().equals(data)) {
            previous = current;
            current = current.getNextNode();
        }

        if (current == null) {
            System.out.println("Node with data " + data + " not found");
            return null;
        }

        T removeData = current.getData();
        previous.setNextNode(current.getNextNode());
        return removeData;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.insertAtBeginning(1);
        list.insertAtBeginning(2);
        list.insertAtBeginning(3);
        list.insertAtBeginning(4);
        list.printLinkedList();
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.printLinkedList();
        list.insertAtBeginning(7);
        list.insertAtBeginning(8);
        list.printLinkedList();
        list.insertAtEnd(9);
        list.insertAtEnd(10);
        list.printLinkedList();
        list.remove(4);
        list.printLinkedList();
        list.remove(4);
        list.printLinkedList();
        list.remove(6);
        list.printLinkedList();
    }

}
