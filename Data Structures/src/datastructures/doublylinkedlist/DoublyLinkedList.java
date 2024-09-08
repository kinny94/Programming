package datastructures.doublylinkedlist;

class Node<T> {

    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}

public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void insertAtBeginning(T data) {
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    public void insertAtPosition(T data, int position) {

        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            insertAtBeginning(data);
        }

        if (position == size) {
            insertAtEnd(data);
        }

        Node<T> newNode = new Node<T>(data);
        Node<T> current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        newNode.setPrev(current);

        if (current.getNext() != null) {
            current.getNext().setPrev(newNode);
        }

        current.setNext(newNode);
        size++;
    }

    public T remove(T data) {

        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }

        if (head == tail) {
            T removedData = head.getData();
            head = null;
            tail = null;
            size--;
            return removedData;
        }

        Node<T> current = head;

        while(current != null && !current.getData().equals(data)) {
            current = current.getNext();
        }

        if (current == null) {
            System.out.println("Element not found");
            return null;
        }

        if (current == head) {
            T removedData = head.getData();
            head = head.getNext();
            head.setPrev(null);
            size--;
            return removedData;
        }

        if (current == tail) {
            T removedData = tail.getData();
            tail = tail.getPrev();
            tail.setNext(null);
            size--;
            return removedData;
        }

        T removedData = current.getData();
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return removedData;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.insertAtBeginning(1);
        list.insertAtBeginning(2);
        list.insertAtBeginning(3);
        list.insertAtBeginning(4);
        list.printList();
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.printList();
        list.insertAtPosition(7, 5);
        list.insertAtPosition(8, 8);
        list.insertAtPosition(9, 2);
        list.printList();
        list.remove(2);
        list.printList();
        list.remove(6);
        list.printList();
    }
}
