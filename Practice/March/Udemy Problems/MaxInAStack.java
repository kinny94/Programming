// get max item in a stack in O(1) time
import java.util.Stack;

class MaxInAStack {

    private Stack<Integer> mainStack;
    private Stack<Integer> maxStack;

    public MaxInAStack() {
        this.mainStack = new Stack<Integer>();
        this.maxStack = new Stack<Integer>();
    }

    public void push(int item) {
        mainStack.push(item);

        if (mainStack.size() == 1) {
            maxStack.push(item);
            return;
        }

        if (item > maxStack.peek()) {
            maxStack.push(item);
        } else {
            maxStack.push(maxStack.peek());
        }
    }

    public int pop() {
        maxStack.pop();
        return mainStack.pop();
    }

    public int getMaxItem() {
        return maxStack.peek();
    }
    
    public static void main(String[] args) {
        MaxInAStack stack = new MaxInAStack();
        stack.push(14);
        stack.push(34);
        stack.push(44);
        stack.push(84);
        stack.push(34);
        stack.push(13);
        stack.push(41);

        System.out.println(stack.getMaxItem());
    }
}