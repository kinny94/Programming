package datastructures.linkedlists;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.insert("Adam");
        names.insert("Anthony");
        names.insert("Victor");
        names.insert("Klay");
        names.insert("Kevin");
        names.insert("Steph");

        names.traverse();

        names.remove("Klay");
        names.remove("Michael");

        System.out.println();
        names.traverse();

        System.out.println();
        System.out.println();

        LinkedList<Person> persons = new LinkedList<>();
        Person klay = new Person(34, "Klay");
        persons.insert(new Person(29, "Adam"));
        persons.insert(new Person(24, "Anthony"));
        persons.insert(new Person(19, "Victor"));
        persons.insert(klay);
        persons.insert(new Person(34, "Kevin"));
        persons.insert(new Person(36, "Steph"));

        persons.traverse();

        persons.remove(klay);
        System.out.println();
        persons.traverse();
    }
}
