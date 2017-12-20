class Queue{

    private static String[] queueArray = new String[100];
    private int rear;
    private final int front = 0;

    Queue(){
        rear = -1;
    }

    public boolean isEmpty(){
        if(rear == -1){
            return true;
        }else{
            return false;
        }
    }

    public void enqueue(String value){
        queueArray[++rear] = value;
    }

    public String dequeue(){
        if(!isEmpty()){
            String retValue = queueArray[front];

            for(int i=front; i<=rear; i++){
                queueArray[i] = queueArray[i+1];
            }

            --rear;
            return retValue;
        }else{
            return "queue is Empty";
        }
    }

    public void displayQueue(){
        for(int i=front; i<=rear; i++){
            System.out.print(queueArray[i] + " : ");
        }
        System.out.println();
    }

    public void clear(){
        for(int i=front; i<=rear; i++){
            System.out.print(queueArray[i] + " : ");
        }
        System.out.println();
    }

    public String qFront(){
        return queueArray[front];
    }

    public String qRear(){
        return queueArray[rear];
    }

    public static void main(String[] args) {
        Queue queuesObj = new Queue();
        queuesObj.enqueue("Tom");
        queuesObj.enqueue("Arjun");
        queuesObj.displayQueue();
        queuesObj.enqueue("Jim");
        queuesObj.enqueue("David");
        queuesObj.displayQueue();
        queuesObj.dequeue();
        System.out.println(queuesObj.qFront());
        System.out.println(queuesObj.qRear());
        queuesObj.displayQueue();
        queuesObj.enqueue("Eric");
        queuesObj.enqueue("Will");
        queuesObj.displayQueue();
        queuesObj.dequeue();
        queuesObj.displayQueue();
    }
}