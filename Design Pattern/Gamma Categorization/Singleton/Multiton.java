// There is  a finite number of instances of the class
// We can use a map to store the instances. We are restricting the number of instances to a finite number.

import java.util.HashMap;
import java.util.Map;

enum SubSystem {
    PRIMARY,
    AUXILIARY,
    FALLBACK
}

class Printer {
    private static int instanceCount = 0;
    private static Map<SubSystem, Printer> instances = new HashMap<>();

    private Printer() {
        instanceCount++;
        System.out.println("A total of " + instanceCount + " instances created so far");
    }

    public static Printer get(SubSystem ss) {
        if (instances.containsKey(ss)) {
            return instances.get(ss);
        }
        Printer printer = new Printer();
        instances.put(ss, printer);
        return printer;
    }
}

public class Multiton {
    public static void main(String[] args) {
        Printer primary = Printer.get(SubSystem.PRIMARY);
        Printer auxiliary = Printer.get(SubSystem.AUXILIARY);
        Printer fallback = Printer.get(SubSystem.FALLBACK);
    }
}
