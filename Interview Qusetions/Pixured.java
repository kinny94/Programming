/* The following program(function) returns the length of the linkedlist. I have implemented a simple linkedlist identical
to the one in the program so that I can implement my function.
*/

class IntList{
    public int value;
    public IntList next;

    IntList(int d) {
        value = d;
        next = null;
    }
}

class Pixured{

    // declaring the head of the list
    IntList head;

    // The function that returns the length of the linkedList
    public int solution(){
        
        IntList temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        return count;
    }

    // A push fucntion to add data to the linkedList
    public void push(int data){
        IntList newNode = new IntList(data);
        newNode.next = head;
        head = newNode;
    }

    // A function to print the list
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

        System.out.println("The length of the list is " + list.solution());
        
        // Comment out the following line to print the list
        //list.printlList();
    }
}