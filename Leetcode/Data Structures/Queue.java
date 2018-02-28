class Queue{

    private static int a[] = new int[10];
    private static int front = 0;
    private static int rear = -1;

    public static void enqueue( int x ){
        
        if( !isFull()){
            a[++rear] = x;
            return;
        }

        System.out.println( "Queue is full!!" );
    }

    public static boolean isFull(){

        if( rear == a.length - 1){
            return true;
        }

        return false;
    }

    public static boolean isEmpty(){
        
        if( rear == -1 ){
            return true;
        }
        
        return false;
    }

    public static int dequeue(){
        
        if( !isEmpty() ){
            int returnValue = a[rear];
            a[rear] = -1;
            --rear;
            return returnValue;
        }

        System.out.println( "Queue is Empty" );
        return -1;
    }

    public static int front(){
        return a[front];
    }

    public static int rear(){
        return a[rear];
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
        Queue queue = new Queue();
        System.out.println( queue.isEmpty());
        System.out.println( queue.isFull() );    
        queue.enqueue(5);
        System.out.println( queue.front());
        System.out.println( queue.rear());
        queue.enqueue(7);
        queue.enqueue( 9 );
        queue.enqueue( 10 );
        System.out.println( queue.front());
        System.out.println( queue.rear());
        queue.dequeue();
        System.out.println( queue.rear());
        System.out.println( queue.search(5));
    }
}