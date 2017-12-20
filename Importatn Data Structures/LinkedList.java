class Link{
    public int current;
    public Link next;

    Link(int current){
        this.current = current;
    }

    public void display(){
        System.out.println("Current : " + current);
    }

    public String toString(){
        return Integer.toString(current);
    }

    public static void main(String[] args) {
        
    }
}

class LinkedList{
    
    public Link firstLink;

    LinkedList(){
        firstLink = null;
    }
    
    public boolean isEmpty(){
        return(firstLink == null);
    }
}mpty or not
    // check if the link is empty or not
    // check if the link is empty or not
    // check if the link is empty or not
    // check if the link is empty or not
    // check if the link is empty or not
    // check if the link is empty or not
    public boolean isEmpty(){
        return(firstLink == null);
    }
}