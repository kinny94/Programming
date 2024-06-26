package datastructures.Stacks;

public class StackLL<T extends Comparable<T>> {

    private Node<T> head;
    private int count;

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public T pop() {

        if(isEmpty()) {
            return null;
        }

        T item = head.getData();
        head = head.getNextNode();
        count--;
        return item;
    }

    public void push(T data) {
        count++;
        if (head != null) {
            head = new Node<>(data);
        } else {
            Node<T> oldHead = head;
            head = new Node<>(data);
            head.setNextNode(oldHead);
        }
    }
}
