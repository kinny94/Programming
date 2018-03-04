/*
    APPROACH
    Take 2 Stacks, stack1 and stack2.
    stack1 will be used as a back of the Queue and stack2 will be used as front of the Queue.
    Push() operation will be done on stack1, and peek() and pop() operations will be done on stack2.
    When peek() and pop() are called, check if stack2 is empty, if yes then move all the elements from stack1 and push them into stack2.

*/


import java.util.Stack;
public class QueueUsingStacks{
    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();

    public void push( int data ){
        stack1.push( data );
    }

    public int peek(){
        if( stack2.empty() ){
            moveItems( stack1, stack2 );
        }
        return stack2.peek();
    }

    public int pop(){
        if( stack2.empty() ){
            moveItems( stack1, stack2 );
        }
        return stack2.pop();
    }

    public void moveItems( Stack<Integer> s1, Stack<Integer> s2 ){
        while( !stack1.isEmpty() ){
            s2.push( s1.pop() );
        }
    }

    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
		q.push(10);
		q.push(20);
		q.push(30);
		System.out.println("POP from Queue " + q.pop());
    }
}