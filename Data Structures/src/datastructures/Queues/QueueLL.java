package datastructures.Queues;

public class QueueLL<T extends Comparable<T>> {

    private Node<T> firstNode;
    private Node<T> lastNode;

    private int count;

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.firstNode == null;
    }

    public void enqueue(T data) {
        this.count++;
        Node<T> oldLastNode = lastNode;
        this.lastNode = new Node<>(data);
        if (isEmpty()) {
            this.firstNode = this.lastNode;
        } else {
            oldLastNode.setNextNode(this.lastNode);
        }
    }

    public T dequeue() {
        this.count--;
        T dataToRemove = this.firstNode.getData();
        this.firstNode = this.firstNode.getNextNode();

        if (isEmpty()) {
            this.lastNode = null;
        }
        return dataToRemove;
    }
}
