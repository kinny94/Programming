class Stack{

    private static int top = -1;
    private static String[] arr;

    Stack( int size ){
        arr = new String[size];
    }

    public static void push( String x ){
        if( !isFull() ){
            arr[++top] = x;
        }else{
            System.out.println(" Stack is Full!" );
        }
    }

    public static String pop(){
        if( !isEmpty() ){
            String returnedValue = arr[top];
            arr[top] = null;
            top--;
            return returnedValue;
        }

        return "Stack is Empty";
    }

    public static boolean isEmpty(){
        if( top == -1){
            return true;
        }
        return false;
    }

    public static boolean isFull(){
        if( top == arr.length ){
            return true;
        }  
        return false;
    }

    public static String peek(){
        if( !isEmpty() ){
            return arr[top];
        }
        
        return "Stack is Empty";
    }

    public static void print(){
        System.out.println();
        for( int i=0; i<arr.length; i++ ){
            System.out.print(" " + arr[i] );
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack st = new Stack(3);
        System.out.println( st.pop() );
        st.push("A");
        st.push("B");
        st.push("C");
        System.out.println( st.peek() );
        st.print();  
        System.out.println( st.pop() );
        System.out.println( st.peek() );
        st.print();
        System.out.println( st.pop() );
        System.out.println( st.peek() );
        System.out.println( st.pop() );
        System.out.println( st.peek() );

    }
}