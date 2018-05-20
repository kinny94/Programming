class Queue{

    private static String[] arr = new String[100];
    private static final int front = 0;
    private static int rear;

    Queue( int size ){
        arr =  new String[ size ];
        rear = -1;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    }

    public static void enqueue( String x ){
        if( !isFull() ){
            arr[ ++rear ] = x;
        }else{
            System.out.println( "Queue is Full!");
        }
    }

    public static String dequeue(){
        if( !isEmpty() ){
            String returnedValue = arr[ front ];
            
            for( int i=front; i<rear; i++ ){
                arr[i] = arr[i+1];
            }
            rear--;
            return returnedValue;
        }
        return "Queue is Empty";
    }

    public static boolean isFull(){
        if( rear == arr.length - 1 ){
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

    public static String qFront(){
        if( !isEmpty() ){
            return arr[ front ];
        }
        return "Queue is Empty";  
    }

    public static String qRear(){
        if( !isEmpty() ){
            return arr[ rear ];
        }
        return "Queue is Empty";
        
    }

    public void displayQueue(){
        for(int i=front; i<=rear; i++){
            System.out.print( arr[i] + " : ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Queue queuesObj = new Queue(5);
        queuesObj.enqueue("Tom");
        queuesObj.enqueue("Arjun");
        queuesObj.displayQueue();
        queuesObj.enqueue("Jim");
        queuesObj.enqueue("David");
        queuesObj.displayQueue();
        queuesObj.dequeue();
        queuesObj.displayQueue();
        queuesObj.enqueue("Eric");
        queuesObj.enqueue("Will");
        queuesObj.displayQueue();
        queuesObj.dequeue();
        queuesObj.displayQueue();
    }

}