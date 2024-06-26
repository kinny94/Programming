package datastructures.Stacks;

public class StackA<T extends Comparable<T>> {

    private int count;
    private T[] stack;

    public StackA() {
        stack = (T[]) new Object[1];
    }

    public void push(T data) {
        if (count == stack.length) {
            resize(2*stack.length);
        }
        stack[count++] = data;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T item = stack[--count];
        stack[count] = null;

        if (count > 0 && count == stack.length / 4) {
            resize(stack.length/2);
        }
        return item;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private void resize(int newSize) {
        T[] stackCopy = (T[]) new Object[newSize];
        if (count >= 0) System.arraycopy(stack, 0, stackCopy, 0, count);
        stack = stackCopy;
    }
}


