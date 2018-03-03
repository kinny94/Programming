import com.sun.corba.se.spi.orbutil.fsm.Action;

class Node<T extends Comparable<T>>{    //extending the comparable to compara whether its a string or an int
    
    private T data;
    private Node<T> nextNode;

    public Node( T data ){
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public void setData( T data ){
        this.data = data;
    }

    public Node<T> getNextNode(){
        return nextNode;
    }

    public void setNode( Node<T> nextNode ){
        this.nextNode = nextNode;
    }

    public String toString(){
        return this.data.toString();
    }
}

public interface List<T>{

    public void insert( T data );
    public void remove( T data );
    public void TraverseList();
    public int size();
    
}

public class LinkedList<T extends Comparable<T>> implements List<T>{

    private Node<T> root;
    private int sizeOfList = 0;

    public void insert( T data ){
        
        ++this.sizeOfList;
        if( root == null ){
            
            this.root = new Node<>( data );

        }else{

            insertDataAtBeginning( data );

        }

    }

    private void insertDataAtBeginning( T data ){

        Node<T> newNode = new Node<>( data );
        newNode.setNextNode( root );
        this.root = newNode;

    }

    private void insertDataAtTheEnd( T data, Node<T> node ){
        
        if( node.setNextNode() != null ){
            insertDataAtTheEnd( data, node.getNextNode());
        }else{
            Node<T> newNode = new Node<>( data );
            node.setNextNode( newNode );
        }

    }

    public void remove( T data ){
        
        if( this.root == null ){
            return;
        }

        --this.sizeOfList;

        if( this.root .getData().compareTo( data ) == 0 ){
            this.root = this.root.getNextNode();
        }else{
            remove( data, root, root.getNextNode());
        }
    }

    private void remove( T dataRoRemove, Node<T> previousNode, Node<T> actualNode ){

        while( actualNode != null ){

            if( actualNode .getData().compareTo( dataRoRemove ) == 0){
                previousNode.setNextNode( actualNode.getNextNode());
                actualNode = null;
            }
            
            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    public int size(){
        return this.sizeOfList;
    }

    public void traverseList(){

        if( this.root == null ) return;

        Node<T> actuaNode = this.root;
        while( actuaNode != null ){
            System.out.print( actuaNode + " - " );
            actuaNode = actuaNode.getNextNode();
        }

    }

}