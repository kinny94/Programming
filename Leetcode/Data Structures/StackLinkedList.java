class Node{
    int data;
    Node next;
    
    public Node( int data ){
        this.data = data;
    }
}

class StackLinkedList{

    Node head = null;
    int size = 0;

    public void push( int data ){
        Node newNode = new Node( data );
        if( getSize() == 0 ){
            head = newNode;
        }else{
            Node temp = head;
            newNode.next = temp;
            head = newNode;
        }
        System.out.println("Element "+ data + " is pushed into Stack");
        size++;
    }

    public int pop(){
        if( getSize() == 0 ){
            System.out.println( "Stack is empty!! ");
            return -1;
        }else{
            Node temp = head;
            head = head.next;
            size--;
            return temp.data;
        }
    }

    public void printStack(){
        Node current = head;
        while( current != null ){
            System.out.println( current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public int getSize(){
        return size;
    }

    public int peek(){
        return head.data;
    }
    public static void main(String[] args) {
        StackLinkedList stck = new StackLinkedList();
        stck.push(1);
        stck.push(2);
        stck.push(4);
        stck.printStack();
        System.out.println(stck.peek());
        System.out.println("Pop out element " + stck.pop());
        stck.printStack();
    }
}