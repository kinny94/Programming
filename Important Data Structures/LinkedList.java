import java.util.*;

class Link{
    
    public LinkedList firstLink;

    Link(){
        firstLink = null;
    }

    public boolean isEmpty(){
        return firstLink == null;
    }

    public void insert(String name){
        LinkedList newLink = new LinkedList(name);
        newLink.next = firstLink;
        firstLink = newLink;
    }

    public LinkedList removeFirst(){
        
        LinkedList linkReference = firstLink;
        if(!isEmpty()){
            firstLink = firstLink.next;
        }else{
            System.out.println("Empty Linked List!!");
        }

        return linkReference;
    }

    public void display(){
        LinkedList theLink = firstLink;
        while(theLink != null){
            theLink.display();
            System.out.println("Next Link : " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }

    public LinkedList find(String name){
        LinkedList theLink = firstLink;

        if(!isEmpty()){
            while(theLink != null){
                if(theLink.next == null){
                    return null;
                }else{
                    theLink = theLink.next;
                }
            }
        }else{
            System.out.println("EmptyLinked List!");
        }

        return theLink;
    }

    public LinkedList remove(String name){

        LinkedList currentLink = firstLink;
        LinkedList previousLink = firstLink;
    
        while(currentLink.name != name){
            if(currentLink.next == null){
                return null;
            }else{
                previousLink = currentLink;
                currentLink = currentLink.next; 
            }
        }

        if(currentLink == firstLink){
            firstLink = firstLink.next;
        }else{
            previousLink.next = currentLink.next;
        }

        return currentLink;
    }
}

class LinkedList{

    public String name;
    public LinkedList next;

    public LinkedList(String name){
        this.name = name;
    }

    public void display(){
        System.out.println("Current name is " + name);
    }

    public String toString(){
        return name;    
    }
    
    public static void main(String[] args) {
    Link newLinkedList = new Link();
    newLinkedList.insert("Harry Potter");
    newLinkedList.insert("Lord of the Rings");
    newLinkedList.insert("Alchemist");
    newLinkedList.insert("Harry Potter");
    newLinkedList.insert("Da Vinci Code");
    newLinkedList.insert("50 Shades of Grey");
    
    newLinkedList.display();
    System.out.println("*****************************\n");
    newLinkedList.removeFirst();
    newLinkedList.display();
    System.out.println("*****************************\n");
    
    System.out.println(newLinkedList.find("Harry Potter"));
    
    System.out.println("*****************************\n");
    
    newLinkedList.remove("Alchemist");
    newLinkedList.display();
    }
}
