class Link {
    
    public String bookname;
    public int millionSold;

    public Link next;

    Link(String bookname, int  millionSold) {
        this.bookname  = bookname;
        this.millionSold = millionSold;
    } 

    public void display() {
        System.out.println(bookname + " : " + millionSold + ",000,000");
    }

    public String toString() {
        return bookname;
    }

    public static void main(String args[]) {
        LinkedList theLinkedList = new LinkedList();
        theLinkedList.insertFirstLink("Book 1", 2);
        theLinkedList.insertFirstLink("Book 2", 3);
        theLinkedList.insertFirstLink("Book 3", 4);
        theLinkedList.insertFirstLink("Book 4", 89);

        theLinkedList.display();

        theLinkedList.removeFirstLink();

        theLinkedList.display();

        System.out.println(theLinkedList.findNode("Book 2").bookname + " is available!!");

        theLinkedList.removeSpecificLink("Book 2");

        theLinkedList.display();
    }
}

class LinkedList {
    public Link firstLink;

    LinkedList() {
        firstLink = null;
    }

    public boolean isEmpty() {
        return firstLink == null;
    }

    public void insertFirstLink(String bookname, int millionSold) {
        Link newLink = new Link(bookname, millionSold);
        newLink.next = firstLink;
        firstLink = newLink;
    }

    public Link removeFirstLink() {
        Link linkedReference = firstLink;
        if(!isEmpty()) {
            firstLink = firstLink.next;
        } else {
            System.out.println("List is empty");
        }
        return linkedReference;
    }

    public void display() {
        Link theLink = firstLink;
        theLink.display();
        while(theLink != null) {
            theLink.display();
            System.out.println("Next Link: " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }

    public Link findNode(String bookname) {
        Link theLink = firstLink;
        
        if (!isEmpty()) {
            while (theLink.bookname != bookname) {
                if (theLink.next == null) {
                    return null;
                } else {
                    theLink = theLink.next;
                }
            }
        } else {
            System.out.println("Empty LinkedList!");
        }

        return theLink;
    }

    public Link removeSpecificLink(String bookname) {
        Link currentLink = firstLink;
        Link previouseLink = firstLink;

        while (currentLink.bookname != bookname) {
            if (currentLink.next == null) {
                return null;
            } else {
                previouseLink = currentLink;
                currentLink = currentLink.next;
            }
        }

        if (currentLink == firstLink) {
            firstLink = firstLink.next;
        } else {
            previouseLink.next = currentLink.next;
        }

        return currentLink;
    }

    public static void main(String args[]) {

    }
}