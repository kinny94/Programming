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

    public void setLink( int data ){
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

    public void insertAtposition( int data, int index ){
        Node pointer = new Node( data, null );
        Node nextNode = start;
        index = index - 1;

        for( int i=1; i<size; i++){
            if( i== index ){
                Node temp2 = nextNode.getLink();
                nextNode.setLink( pointer );
                pointer.setLink( temp2 );
                break;
            }
            nextPointer = nextNode.getLink();
        }
    }
}