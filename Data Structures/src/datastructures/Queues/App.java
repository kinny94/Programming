package datastructures.Queues;

public class App {
    public static void main(String[] args) {
        QueueLL<String> queue = new QueueLL<>();
        queue.enqueue("Anthony");
        queue.enqueue("Lebron");
        queue.enqueue("Victor");
        queue.enqueue("Jayson");
        queue.enqueue("Jaylen");

        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());


    }
}
