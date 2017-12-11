class IntList{
    public int value;
    public IntList next;

    IntList(int d) {
        value = d;
        next = null;
    }
}

class Pixured{
    IntList head;

    public void push(int data){
        IntList newNode = new IntList(data);
        newNode.next = head;
        head = newNode;
    }
    
    public int getCount(){

        IntList temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        return count;
    }

    public void printlList(){
        while(head != null){
            System.out.print(head.value + " -> ");
            head = head.next;
        }
    }

    public static void main(String args[]){
        Pixured list = new Pixured();
        
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.push(6);

        System.out.println("The length of the list is " + list.getCount());
        list.printlList();
    }
}