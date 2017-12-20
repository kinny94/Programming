class LinkedList{
    
    public Link firstLink;

    LinkedList(){
        firstLink = null;
    }
    
    // check if the link is empty or not
    public boolean isEmpty(){
        return(firstLink == null);
    }

    // adding at the first position
    public void insertFirst(int link){
        Link newLink = new Link(link);
        newLink.next = firstLink;
        firstLink = newLink;
    }

    public Link removeFirst(){
        Link linkReference = firstLink;
        if(!isEmpty()){
            firstLink = firstLink.next;
        }else{
            System.out.println("Empty LinkedList!!");
        }

        return linkReference;
    }

    public void display(){
        Link theLink = firstLink;
        while(theLink != null){
            System.out.print(theLink.current + " ->");
            theLink = theLink.next;
        }
        System.out.print(" null");
        System.out.println();
    }

    public Link findLink(int key){
        Link theLink = firstLink;
        if(!isEmpty()){
            while(theLink.current != key){
                if(theLink.next == null){
                    return null;
                }else{
                    theLink = theLink.next;
                }
            }
        }else{
            System.out.println("Empty List!");
        }
        return theLink;
    }

    public Link removeLink(int key){
        Link theLink = firstLink;
        Link previousLink = firstLink;

        while(theLink.current != key){
            if(theLink.next == null){
                return null;
            }else{
                previousLink = theLink;
                theLink = theLink.next;
            }
        }

        if(theLink == firstLink){
            firstLink = firstLink.next;
        }else{
            previousLink.next = theLink.next;
        }

        return theLink;
    }
}

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
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(5);
        linkedList.insertFirst(10);
        linkedList.insertFirst(15);
        linkedList.insertFirst(20);
        linkedList.insertFirst(25);

        linkedList.display();

        linkedList.removeFirst();
        linkedList.display();

        linkedList.insertFirst(25);
        linkedList.display();

        linkedList.removeLink(15);
        linkedList.display();
    }
}
