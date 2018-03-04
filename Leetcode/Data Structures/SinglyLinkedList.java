import java.util.*;
class Node{

    Node link = null;
    int data = 0;

    public Node(){
        link = null;
        data = 0;
    }

    public Node( int data, Node link ){
        this.data = data;
        this.link = link;
    }

    public Node getLink(){
        return this.link;
    }

    public void setLink( Node link ){
        this.link = link;
    }

    public int getData(){
        return data;
    }

    public void setData( int data ){
        this.data = data;
    }
}

class LinkedListImplementation{

    Node start = null;
    Node end = null;
    int size = 0;

    public LinkedListImplementation(){
        start = null;
        end = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return start == null;
    }

    // Inserting at the start of the list
    public void insertAtStart( int data ){
        Node pointer = new Node( data, null );
        if( start == null ){
            start = pointer;
            end = pointer;
        }else{
            pointer.setLink( start );
            start = pointer;
        }
        size++;
    }

    // inserting at the end of the list
    public void insertAtEnd( int data ){
        Node pointer = new Node( data, null );
        if( start == null ){
            start = pointer;
            end = pointer; 
        }else{
            end.setLink( pointer );
            end = pointer;
        }
        size++;
    }

    // inserting at a particular index O(N)
    public void insertAtposition( int data, int index ){
        Node pointer = new Node( data, null );
        Node nextNode = start;
        index = index - 1;

        for( int i=1; i<size; i++){
            if( i == index ){
                Node temp2 = nextNode.getLink();
                nextNode.setLink( pointer );
                pointer.setLink( temp2 );
                break;
            }
            nextNode = nextNode.getLink();
        }
    }

    public void replaceDataAtPosition( int data, int position ){
        if( start == null ){
            System.out.println("Empty!!");
            return;
        }

        Node pointer = start;
        for( int i=0; i<size; i++ ){
            if( i == position ){
                pointer.setData( data );
            }
            pointer = pointer.getLink();
        }
    }

    public void deleteAtPosition( int position ){

        if( start == null ){
            System.out.println("Empty!!");
            return;
        }

        // Deleting the last element
        if( position == size ){
            Node startPointer = start; 
            Node endPointer = start;
            while( startPointer != null ){
                endPointer = startPointer;
                startPointer = startPointer.getLink();            
            }      
            end = endPointer;
            end.setLink( null );
            size--;
            return;
        }

        //Deleting anywhere in the list
        Node pointer = start;
        position = position - 1;
        for( int i=1; i<size; i++ ){
            if( i == position ){
                Node temp = pointer.getLink();
                temp = temp.getLink();
                pointer.setLink( temp );
                break;
            }
            pointer = pointer.getLink();
        }
        size--;
    }

    public void deleteNodeByData( int data ){

        // If its an empty linked list
        if( start == null ){
            System.out.println("Empty@!!");
            return;
        }

        // If its the first element to be deleted and only a single element in the list
        if( start.getData() == data  && start.getLink() == null ){
            start = null;
            end = null;
            size--;
            return;
        } 

        //If we wanna delete the first element in the link and there's more than one element in the list
        if( start.getData() == data && start.getLink() != null ){
            start = start.getLink();
            size--;
            return;
        }

        //If we wanna delete the last element in the list
        if( end.getData() == data ){
            Node startPointer = start;
            Node endPointer = start;

            startPointer = startPointer.getLink();
            while( startPointer.getLink() != null ){
                endPointer = startPointer;
                startPointer = startPointer.getLink();
            }

            end = endPointer;
            end.setLink( null );
            size--;
            return;
        }

        // Anywhere else in the list
        Node startPointer = start;
        Node previousPointer = startPointer;
        startPointer = startPointer.getLink();
        while( startPointer.getData() != data && startPointer.getLink() != null ){
            previousPointer = startPointer;
            startPointer = startPointer.getLink();
        }

        if( startPointer.getData() == data ){
            Node temp = previousPointer.getLink();
            previousPointer.setLink( temp );
            size--;
            return;
        }

        System.out.println(data + " not found!!");
    }

    // printing the linked list
    public void display(){
        if( start == null ){
            System.out.println("Empty!!");
            return;
        }

        if( start.getLink() == null ){
            System.out.println( start.getData() );
            return;
        }

        Node pointer = start;
        System.out.print( pointer.getData() + " -> ");
        pointer = start.getLink();
        while( pointer.getLink() != null ){
            System.out.print( pointer.getData() + " -> ");
            pointer = pointer.getLink();
        }
        System.out.print( pointer.getData() );
        System.out.println();
    }

    public void searchElementByPosition( int position ){
        if( position == 1 ){
            System.out.println( "Element at position " + position + " is " + start.getData() );
            return;
        }

        if( position == size ){
            System.out.println( "Element at position " + position + " is " + end.getData() );
            return;
        }

        Node pointer = start;
        for( int i=1; i<size; i++ ){
            if( i== position ){
                System.out.println( "Element at position " + position + " is " + pointer.getData() );
                return;
            }
            pointer = pointer.getLink();
        }
    }

    public void searchElementIteratively( int data ){
        if( isEmpty() ){
            System.out.println( "Empty!!");
            return;
        }

        if( start.getData() == data ){
            System.out.println( data + " found at position " + 1);
            return;
        }

        if( start.getLink() != null && end.getData() == data ){
            System.out.println( data + " found at position " + size );
            return;
        }

        Node startPointer = start;
        int position = 0;
        while( startPointer.getLink() != null ){
            ++position;
            if( startPointer.getData() == data ){
                break;
            }
            startPointer = startPointer.getLink();
        }

        if( startPointer.getData() ==  data ){
            System.out.println( data + " found at position " + position );
            return;
        }

        System.out.println(data + " Not found!");
    }

    public void searchElementByReccursion( Node start, int data, int count ){
        if( isEmpty() ){
            System.out.println( "Empty!!");
            return;
        }

        if( start.getData() == data ){
            System.out.println( data + " found at position " + (++count));
            return;
        }

        if( start.getLink() == null ){
            System.out.println( data + " not found! ");
            return;
        }

        searchElementByReccursion(start.getLink(), data, ++count);
    }
}

class SinglyLinkedList {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        LinkedListImplementation listImpl = new LinkedListImplementation();
        System.out.println("Singly Linked list : ");
        boolean yes = true;
        do {
            System.out.println("1 Insert At Start :");
            System.out.println("2 Insert At End :");
            System.out.println("3 Insert At any Position :");
            System.out.println("4 Delete At any Position :");
            System.out.println("5 Display :");
            System.out.println("6 Get Size");
            System.out.println("7 Empty Status");
            System.out.println("8 Replace data at given postion");
            System.out.println("9 Search Element by position ");
            System.out.println("10 Delete a Node by Given Data");
            System.out.println("11 Search Element Iteratively");
            System.out.println("12 Search Element Recursively");
            System.out.println("13 Exit :");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
            case 1:
                listImpl.insertAtStart(scanner.nextInt());
                break;

            case 2:
                listImpl.insertAtEnd(scanner.nextInt());
                break;

            case 3:
                int position = scanner.nextInt();
                if (position <= 1 || position > listImpl.getSize()) {
                    System.out.println("invalid position!");
                } else {
                    listImpl.insertAtposition(position, scanner.nextInt());
                }
                break;

            case 4:
                int deletePosition = scanner.nextInt();
                if (deletePosition <= 1 || deletePosition > listImpl.getSize()) {
                    System.out.println("invalid position!");
                } else {
                    listImpl.deleteAtPosition(deletePosition);
                }
                break;

            case 5:
                listImpl.display();
                break;

            case 6:
                System.out.println(listImpl.getSize());
                break;

            case 7:
                System.out.println(listImpl.isEmpty());
                break;

            case 8:
                int replacePosition = scanner.nextInt();
                if (replacePosition < 1 || replacePosition > listImpl.getSize()) {
                    System.out.println("Invalid position!");
                } else {
                    listImpl.replaceDataAtPosition(replacePosition, scanner.nextInt());
                }
                break;

            case 9:
                int searchPosition = scanner.nextInt();
                if (searchPosition < 1 || searchPosition > listImpl.getSize()) {
                    System.out.println("Invalid position!");
                } else {
                    listImpl.searchElementByPosition(searchPosition);
                }
                break;

            case 10:
                listImpl.deleteNodeByData(scanner.nextInt());
                break;

            case 11:
                listImpl.searchElementIteratively(scanner.nextInt());
                break;

            case 12:
                listImpl.searchElementByReccursion(listImpl.start, scanner.nextInt(), 0);
                break;

            default:
                System.out.println("invalid choice");
                break;
            }
        } while (yes);
    }
}
