package datastructures.queue;

public class Queue<T> {

    private T[] queue;
    private int front;
    private int rear;
    private int size;

    Queue(int size) {
        this.queue = (T[]) new Object[size];
        this.front = -1;
        this.rear = -1;
        this.size = size;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public void enqueue(T value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear = rear + 1;
        queue[rear] = value;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        T temp = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = front + 1;
        }
        return temp;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return queue[front];
    }

    // Print all elements in the queue
    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty!!");
            return;
        }
        for (int i=front; i < rear; i++) {
            System.out.print(queue[i] + " -> ");
        }
        System.out.print(queue[rear] + " ");  // Print the last element
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> intQueue = new Queue<>(5);
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        intQueue.print();
        System.out.println("Peek: " + intQueue.peek());
        intQueue.enqueue(4);
        intQueue.enqueue(5);
        intQueue.print();
        System.out.println("Dequeue: " + intQueue.dequeue());
        System.out.println("Dequeue: " + intQueue.dequeue());
        intQueue.print();

        // Testing with String type
        Queue<String> stringQueue = new Queue<>(3);
        stringQueue.enqueue("Hello");
        stringQueue.enqueue("World");
        stringQueue.print();
        System.out.println("Peek: " + stringQueue.peek());
        stringQueue.enqueue("Java");
        stringQueue.print();
        System.out.println("Dequeue: " + stringQueue.dequeue());
        stringQueue.print();
    }

}
