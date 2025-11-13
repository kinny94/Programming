import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class BasicSingleton implements Serializable {
    // nobody can create a new instance of the singleton - since the constructor is private
    private BasicSingleton() {
        System.out.println("Initializing a singleton");
    }

    private static final BasicSingleton INSTANCE = new BasicSingleton();

    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BasicSingleton [value=" + value + "]";
    }

    // we need this method to ensure that the singleton is not serialized and deserialized
    protected Object readResolve() {
        return INSTANCE;
    }
}

public class Singleton {

    static void saveToFile(BasicSingleton singleton, String filename) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(singleton);
        }
    }

    static BasicSingleton readFromFile(String filename) throws Exception {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (BasicSingleton) ois.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        // BasicSingleton singleton = BasicSingleton.getInstance();
        // singleton.setValue(123);
        // System.out.println(singleton);
        // System.out.println(singleton.getValue());
        
        // Reflections - 1st Issue
        // Serialization - 2nd Issue - When you deserialize a singleton, you get a new instance, it won't care that the constructor is private
        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(111);
        saveToFile(singleton, "singleton.bin");
        singleton.setValue(222);
        BasicSingleton singleton2 = readFromFile("singleton.bin");
        System.out.println(singleton == singleton2);
        System.out.println(singleton);
        System.out.println(singleton2);
    }
}
