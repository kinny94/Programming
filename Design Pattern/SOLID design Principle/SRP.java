// Single Responsibility Principle - A class should have only one responsibility
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

// If you don't follow this, you might end with a God object which is hard to maintain and test
// Also, it violates the Open/Closed Principle
// If you need to add a new functionality, you need to modify the existing class
// This is not a good design
public class SRP {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text) {
        entries.add("" + count + ": " + text);
        count++;
    }

    public void removeEntry(int index) {
        entries.remove(index);
        count--;
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }

    public void saveToFile(String filename) throws IOException {
        try (PrintStream out = new PrintStream(new File(filename))) {
            out.println(toString());
        }
    }

    // Following are the stuff that violates SRP
    public static void main(String[] args) throws Exception {
        SRP srp = new SRP();
        srp.addEntry("Hello");
        srp.addEntry("World");
        System.out.println(srp);
        srp.saveToFile("srp.txt");

        Persistence persistence = new Persistence();
        String filename = "srp.txt";
        persistence.saveToFile(srp, filename, true);
        srp.load(filename);
        System.out.println(srp);
    }

    public void load(String filename) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = in.readLine()) != null) {
                entries.add(line);
            }
        }
    }
}

// Following is separate class that handles the persistence of the SRP class
// This is a good example of SRP
// We are separating the responsibility of the SRP class to handle the persistence of the data
class Persistence {
    public void saveToFile(SRP srp, String filename, boolean overwrite) throws IOException {

        if (overwrite || new File(filename).exists()) {
            try (PrintStream out = new PrintStream(new File(filename))) {
                out.println(srp.toString());
            }
        }
        else {
            System.out.println("File already exists");
        }
    }
}
