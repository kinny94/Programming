package datastructures.stacks;

public class Stacks<T> {

    private T[] a;
    private int top;

    // Constructor to initialize stack with a given size
    @SuppressWarnings("unchecked")
    Stacks(int size) {
        a = (T[]) new Object[size];  // Create a generic array
        top = -1;  // Initialize to -1 to indicate empty stack
    }

    // Push method to add an element to the stack
    public void push(T x) {
        if (isFull()) {
            System.out.println("Stack is full!!");
            return;
        }
        a[++top] = x;  // Increment top and assign value
    }

    // Pop method to remove and return the top element
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!!");
            return null;
        }
        return a[top--];  // Return value and decrement top
    }

    // Peek method to view the top element without removing it
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!!");
            return null;
        }
        return a[top];  // Return current top value
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;  // Stack is empty if top is -1
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == a.length - 1;  // Stack is full if top is at the last index
    }

    // Print all elements in the stack
    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("TOP IS: " + top);
        System.out.println();
    }

    // Main method to test the generic stack
    public static void main(String[] args) {
        Stacks<Integer> intStack = new Stacks<>(5);
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.print();
        System.out.println("Peek: " + intStack.peek());
        intStack.push(4);
        intStack.push(5);
        intStack.print();
        System.out.println("Pop: " + intStack.pop());
        System.out.println("Pop: " + intStack.pop());
        intStack.print();

        // Testing with String type
        Stacks<String> stringStack = new Stacks<>(3);
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.print();
        System.out.println("Peek: " + stringStack.peek());
        stringStack.push("Java");
        stringStack.print();
        System.out.println("Pop: " + stringStack.pop());
        stringStack.print();
    }
}