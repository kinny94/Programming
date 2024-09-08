package datastructures.circularlinkedlist;

import javax.print.event.PrintEvent;

class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }
}

public class CircularLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node<T> current = head;
        System.out.println("List: ");
        for (int i = 0; i < size; i++) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("(head)");
    }

    public void insertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            tail.setNext(head);
        } else {
            newNode.setNext(head);
            head = newNode;
            tail.setNext(head);
        }
        size++;
    }

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            tail.setNext(head);
        } else {
            tail.setNext(newNode);
            tail = newNode;
            tail.setNext(head);
        }
        size++;
    }

    public void insertAtPosition(T data, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        if (position == size + 1) {
            insertAtEnd(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> current = head;

        for (int i = 1; i < position - 1; i++) {
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }

    public T remove(T data) {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return null;
        }

        Node<T> current = head;
        Node<T> prev = tail;

        for (int i = 0; i < size; i++) {
            if (current.getData().equals(data)) {
                break;
            }
            prev = current;
            current = current.getNext();
        }

        if (!current.getData().equals(data)) {
            System.out.println("Node with data " + data + " not found.");
            return null;
        }

        if (head == tail) {
            T removedData = head.getData();
            head = null;
            tail = null;
            size--;
            return removedData;
        }

        if (current == head) {
            T removedData = head.getData();
            head = head.getNext();
            tail.setNext(head);
            size--;
            return removedData;
        }

        T removedData = current.getData();
        prev.setNext(current.getNext());

        if (current == tail) {
            tail = prev;
            tail.setNext(head);
        }

        size--;
        return removedData;
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<Integer>();
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
