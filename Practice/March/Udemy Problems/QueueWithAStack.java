import java.util.Stack;

// implement a queue using stacks
// we need to maintain two stacks, one for enqueue and one for dequeue

// can also be done with recurrsion instead of using the second stack, but it will still be using a stack, since the os will maintain a stack for the recurrsion calls
class QueueWithAStack {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    QueueWithAStack() {
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
    }

    public void enqueue(int item) {
        this.enqueueStack.push(item);
    }

    public int dequeue() {
        if (enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
            throw new RuntimeException("Stacks are empty");
        }

        if (dequeueStack.isEmpty()) {
            while(!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        return dequeueStack.pop();
    }

    public static void main(String[] args) {
        QueueWithAStack queue = new QueueWithAStack();
        queue.enqueue(10);
        queue.enqueue(5);
        queue.enqueue(20);
        
        System.out.println(queue.dequeue());

        queue.enqueue(100);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}