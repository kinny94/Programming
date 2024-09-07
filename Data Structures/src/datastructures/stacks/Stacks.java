package datastructures.stacks;

public class Stacks {

    int[] a;
    int top = 0;

    Stacks(int size) {
       a = new int[size];
    }

    public void push(int x) {
        // check if the stack if full
        if (top == a.length) {
            System.out.println("Stack is full!!");
        }
        a[top] = x;
        if (top == a.length - 1) {
            return;
        }
        top++;
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!!");
        }
        int temp = a[top];
        a[top--] = 0;
        return temp;
    }

    public Integer peek() {
        if (isFull()) {
            System.out.println("Stack is empty!!");
        }
        return a[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == a.length - 1;
    }

    public void print() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("TOP IS: " + top);
        System.out.println();
    }

    public static void main(String[] args) {
        Stacks s = new Stacks(5);
        s.push(1);
        s.push(2);
        s.push(3);
        s.print();
        System.out.println(s.peek());
        s.push(4);
        s.push(5);
        s.print();
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.print();
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.print();
        System.out.println(s.pop());
    }
}
