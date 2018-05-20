import java.util.Currency;

class Node{
    public String name;
    public Node next;

    Node( String name ){
        this.name = name;
        this.next = null;
    }

}

class LinkedList{

    public Node head;
    public int size;

    LinkedList(){
        head = null;
    }

    public void addAtBegin( String data ){
        Node n = new Node( data );
        n.next = head;
        head = n;
        size++;
    }

    public String deleteAtBegin(){
        String tmp = head.name;
        head = head.next;
        size--;
        return tmp;
    }

    public void deleteAtEnd(){
        Node currNode = head;
        if( head.next == null ){
            head = null;
        }else{
            while( currNode.next.next != null ){
                currNode = currNode.next;
            }

            String temp = currNode.next.name;
            currNode.next = null;
            size--;
        }
    }

    public void addAtEnd( String data ){
        if( head == null ){
            addAtBegin( data );
        }else{
            Node n = new Node( data );
            Node curNode = head;
            while( curNode.next != null ){
                curNode = curNode.next;
            }

            curNode.next = n;
            size++;
        }
    }

    public String elementAt( int index ){
        if( index > size ){
            return "Invalid Search";
        }

        Node n = head;
        while( index - 1 != 0 ){
            n = n.next;
            index--;
        }
        return n.name;
    }

    public int getSize(){
        return size;
    }

    public int search( String data ){
        Node n = head;
        int count = 1;
        while( n != null ){
            if( n.name == data ){
                return count;
            }else{
                n = n.next;
                count++;
            }
        }
        return -1;
    }

    public void addAtIndex( String data, int position ){
        if( position == 1 ){
            addAtBegin( data );
        } 

        int len = size;  
        if( position > len + 1 || position < 1 ){
            System.out.println("Invalid position");
        }

        if( position == len + 1 ){
            addAtEnd( data );
        }

        if( position<=len && position > 1 ){
            Node n = new Node( data );
            Node curNode = head;
            while( (position-2) > 0 ){
                System.out.println( curNode.name );
                curNode = curNode.next;
                position--; 
            }
            n.next = curNode.next;
            curNode.next = n;
            size++;
        }
    }

    public void display() {
		System.out.println("");
		Node currNode = head;
		while (currNode != null) {
			System.out.print("->" + currNode.name);
			currNode = currNode.next;
		}
    }
    
    public static void main(String[] args) {
        LinkedList a = new LinkedList();
		a.addAtBegin("5");
		a.addAtBegin("15");
		a.addAtEnd("20");
		a.addAtEnd("21");
		a.deleteAtBegin();
		a.deleteAtEnd();
		a.addAtIndex("10", 2);
		a.addAtEnd("15");
		a.display();
		System.out.println("\n Size of the list is: " + a.size);
		System.out.println(" Element at 2nd position : " + a.elementAt(2));
		System.out.println(" Searching element 20, location : " + a.search("15"));
    }
}