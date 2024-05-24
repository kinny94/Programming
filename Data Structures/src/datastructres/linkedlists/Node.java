package datastructres.linkedlists;

public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> nextNode;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return data +
                " -> ";
    }
}