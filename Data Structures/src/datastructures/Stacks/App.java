package datastructures.Stacks;

public class App {

    public static void main(String[] args) {
        StackLL<String> names = new StackLL<>();
        names.push("Anthony");
        names.push("Karl");
        names.push("Ruby");
        names.push("Derek");

        StackA<String> namesA = new StackA<>();
        namesA.push("Anthony");
        namesA.push("Karl");
        namesA.push("Ruby");
        namesA.push("Derek");

        while(!namesA.isEmpty()) {
            System.out.println(namesA.pop());
        }
    }
}
