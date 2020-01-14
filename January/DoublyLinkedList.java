class Neighbor {
    public String homeOwnerName;
    public int houseNumber;
    public Neighbor next;
    public Neighbor previous;

    Neighbor(String homeOwnerName, int houseNumber) {
        this.homeOwnerName = homeOwnerName;
        this.houseNumber =  houseNumber;
    }

    public void display() {
        System.out.println(homeOwnerName + " : " + houseNumber + " Privet Drive");
    }

    public String toString() {
        return homeOwnerName;
    }
}

class NeighborIterator {
    Neighbor currentNeighbor;
    Neighbor previouseNeighbor;

    DoublyLinkedList theNeighbors;

    NeighborIterator(DoublyLinkedList theNeighbors) {
        this.theNeighbors = theNeighbors;
        currentNeighbor = theNeighbors.firstLink;
        previouseNeighbor = theNeighbors.lastLink;
    }

    public boolean hasNext() {
        if (currentNeighbor.next != null) {
            return true;
        } 
        return false;
    }

    public Neighbor next() {
        if(hasNext()) {
            previouseNeighbor = currentNeighbor;
            currentNeighbor = currentNeighbor.next;
            return currentNeighbor;
        }

        return null;
    }

    public void remove() {
        if (previouseNeighbor == null) {
            theNeighbors.firstLink = currentNeighbor.next;
        } else {
            previouseNeighbor.next = currentNeighbor.next;
            if (currentNeighbor.next == null) {
                currentNeighbor = theNeighbors.firstLink;
                previouseNeighbor = null;
            } else {
                currentNeighbor = currentNeighbor.next;
            }
        }
    }
    
}

public class DoublyLinkedList {
    
    Neighbor firstLink;
    Neighbor lastLink;

    public void insertInFirstPosition(String homeOwnerName, int houseNumber) {
        Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
        if (isEmpty()) {
            lastLink = theNewLink;
        } else {
            firstLink.previous = theNewLink;
        }

        theNewLink.next = firstLink;
        firstLink = theNewLink;
    }

    public void insertAtLastPosition(String homeOwnerName, int houseNumber) {
        Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

        if (isEmpty()) {
            firstLink = theNewLink;
        } else {
            lastLink.next = theNewLink;
            theNewLink.previous = lastLink;
        }

        lastLink = theNewLink;
    }

    public boolean isEmpty() {
        return firstLink == null;
    }

    public boolean insertAfterKey(String homeOwnerName, int houseNumber, int key) {
        Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
        Neighbor currentNeighbor = firstLink;

        while(currentNeighbor.houseNumber != key) {
            currentNeighbor = currentNeighbor.next;
            if (currentNeighbor == null) {
                return false;
            }
        }

        if (currentNeighbor == lastLink) {
            theNewLink.next  = null;
            lastLink = theNewLink;
        } else {
            theNewLink.next = currentNeighbor.next;
            currentNeighbor.next.previous = theNewLink;
        }

        theNewLink.previous = currentNeighbor;
        currentNeighbor.next = theNewLink;
        return true;

    }
 
    public void insertInOrder(String homeOwnerName, int houseNumber) {
        Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
        Neighbor previouseNeighbor = null;
        Neighbor currentNeighbor = firstLink;

        while (currentNeighbor != null && houseNumber > currentNeighbor.houseNumber) {
            previouseNeighbor = currentNeighbor;
            currentNeighbor = currentNeighbor.next;
        }

        if (previouseNeighbor == null) {
            firstLink = theNewLink;
        } else {
            previouseNeighbor.next = theNewLink; 
        }

        theNewLink.next = currentNeighbor;
    }

    public static void main(String[] args) {
        DoublyLinkedList theLinkedList = new DoublyLinkedList();
        theLinkedList.insertInOrder("Name 1", 9);
        theLinkedList.insertInOrder("Name 2", 2);
        theLinkedList.insertInOrder("Name 3", 1);
        theLinkedList.insertInOrder("Name 4", 4);

        theLinkedList.insertAfterKey("Name 5", 10, 4);

        theLinkedList.display();

        System.out.println("\n");

        NeighborIterator neighbors = new NeighborIterator(theLinkedList);
        neighbors.currentNeighbor.display();
    }

    public void display() {
        Neighbor theLink = firstLink;
        while (theLink != null) {
            theLink.display();
            System.out.println("Next Link " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }
}