class Stack{

    private static String[] stackarray = new String[100];
    int top;

    Stack(){
        top = -1;
    }

    public void push(String data){
        if(!isFull()){
            stackarray[++top] = data;
        }else{
            System.out.println("Stack is full!!");
        }
    }

    public String pop(){
        String retValue = stackarray[top--];
        return retValue;
    }

    public boolean isFull(){
        if(top == 100){
            return true;
        }else{
            return false;
        }
    }

    public String peek(){
        return stackarray[top];
    }

    public void clear(){
        for(int i=0; i<top-1; i++){
            stackarray[i] = "";
        }
    }

    public int count(){
        return top+1;
    }

    public void print(){
        for(int i=0; i<top-1; i++){
            System.out.print(stackarray[i] + " | " );
        }
    }

    public static void main(String args[]){
        Stack stackObj = new Stack();
        
        stackObj.push("Arjun");
        stackObj.push("Tom");

        System.out.println(stackObj.peek());
        System.out.println(stackObj.count());

        stackObj.push("David");
        stackObj.push("Jim");

        System.out.println(stackObj.peek());
        System.out.println(stackObj.count());

        stackObj.pop();

        System.out.println(stackObj.peek());
        System.out.println(stackObj.count());

        stackObj.push("Jim");
        stackObj.push("Eric");
        stackObj.push("Terrance");
    }
}

