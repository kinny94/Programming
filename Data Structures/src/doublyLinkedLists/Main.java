package doublyLinkedLists;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList<String> names = new DoublyLinkedList<>();
        names.insert("Steph");
        names.insert("Klay");
        names.insert("Jaylen");
        names.insert("Jayson");

        names.traverseBackward();
        System.out.println();
        names.traverseForward();
    }
}
