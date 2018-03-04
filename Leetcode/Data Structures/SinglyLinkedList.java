import apple.laf.JRSUIConstants.State;

public class Node{

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

class LinkedList{

    Node start = null;
    Node end = null;
    int size = 0;

    public LinkedList(){
        start = null;
        end = null;
        size = 0;
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
            Sytem.out.println("Empty!!");
            return;
        }

        Node pointer = start;
        for( int i=0; i<size; i++ ){
            if( i == position ){
                pointer.setData( data );
            }
            nextNode = pointer.getLink();
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
        if( start == null ){
            System.out.println("Empty@!!");
            return;
        }

        if( start.getData() == data  && start.getLink() == null ){
            start = null;
            end = null;
            size--;
            return;
        } 

        if( start.getData() == data && start.getLink() != null ){
            start = start.getLink();
            size--;
            return;
        }

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


}