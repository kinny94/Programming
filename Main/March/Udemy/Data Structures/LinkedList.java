class Node{
    
    public int data;
    public Node next;

    public Node( int data ){
        this.data = data;
        this.next = null;
    }
}

class LinkedListImplementation{

    public Node head;
    public int size;

    public LinkedListImplementation(){
        head = null;
    }

    public void addAtBegin( int data ){
        Node newNode = new Node( data );
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtEnd( int data ){
        if( head == null ){
            addAtBegin( data );
        }else{
            Node newNode = new Node( data );
            Node currentNode = head;
            while( currentNode.next != null ){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            size++;
        }
    }

    public void addAtIndex( int data, int position ){
        if( position == 1 ){
            addAtBegin( data );
        }
        if( position > size + 1 || position < 1 ){
            System.out.println( "Invalid position!" );
        }
        if( position <= size &&  position > 1 ){
            Node newNode = new Node( data );
            Node currentNode = head;
            while(( position - 2 ) > 0 ){
                System.out.println( currentNode.data );
                currentNode = currentNode.next;
                position--;
            }

            newNode.next = currentNode.next;
            currentNode.next = newNode;
            size++;
        }
    }

    public int deleteAtBegin(){
        int temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    public void deleteAtEnd(){
        Node currentNode = head;
        if( head.next == null ){
            head = null;
        }else{
            while( currentNode.next.next != null ){
                currentNode = currentNode.next;
            }
            int temp = currentNode.next.data;
            currentNode.next = null;
            size--;
        }
    }

    public int elementAt( int index ){
        if( index > size ){
            return -1;
        }

        Node newNode = head;
        while( index-1 != 0 ){
            newNode = newNode.next;
            index--;
        }

        return newNode.data;
    }

    public int getSize(){
        return size;
    }

    public int search( int data ){
        Node n = head;
		int count = 1;
		while(n!=null){
			if(n.data==data){
				return count - 1;
			}else{
				n = n.next;
				count++;
			}
		}
		return -1;
    }

    public void display(){
        System.out.println("");
		Node currNode = head;
		while (currNode != null) {
			System.out.print("->" + currNode.data);
			currNode = currNode.next;
		}
    }

}

class LinkedList{
    public static void main(String[] args) {
        LinkedListImplementation a = new LinkedListImplementation();
        a.addAtBegin(5);
		a.addAtBegin(15);
		a.addAtEnd(20);
		a.addAtEnd(21);
		a.deleteAtBegin();
		a.deleteAtEnd();
		a.addAtIndex(10, 2);
		a.addAtEnd(15);
		a.display();
		System.out.println("\n Size of the list is: " + a.size);
		System.out.println(" Element at 2nd position : " + a.elementAt(2));
    }
}