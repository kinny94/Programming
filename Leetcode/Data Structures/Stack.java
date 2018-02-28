class Stack{

    private static int a[] = new int[10];
    private static int top = -1;

    public static void push( int x ){
        
        if( isFull() ){
            System.out.println( "Stack is Full!!" );
        }
        
        a[++top] = x;
    }

    public static int pop(){
        
        if( isEmpty() ){
            System.out.println( "Stack is Empty" );
        }

        int returnValue = a[top];
        a[top] = -1;
        --top;
        return returnValue;
    
    }

    public static int peek(){
        return a[top];
    }

    public static boolean isEmpty(){
        
        if( top == -1 ){
            return true;
        } 
        
        return false;
    }

    public static boolean isFull(){
        
        if( top == a.length-1 ){
            return true;
        }

        return false;
    }

    public static int search( int x ){

        for( int i=0; i<a.length; i++ ){
            if( a[i] == x ){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        
        Stack stack = new Stack();
        System.out.println( stack.isEmpty() );
        stack.push(5);
        System.out.println( stack.peek() );
        System.out.println( stack.isEmpty() );
        stack.push( 7 );
        stack.push( 9 );
        stack.push( 12 );
        System.out.println( stack.peek() );
        stack.pop();
        System.out.println( stack.peek());
        stack.push( 12 );
        System.out.println( stack.search(5));
        System.out.println( stack.search(9));
    }
}