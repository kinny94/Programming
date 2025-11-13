import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

enum EnumBasedSingletonEnum {
    INSTANCE;

    // enum constructor is always private
    EnumBasedSingletonEnum() {
        value = 42;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class EnumBasedSingleton {
    static void saveToFile(EnumBasedSingletonEnum singleton, String filename) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(singleton);
        }
    }

    static EnumBasedSingletonEnum readFromFile(String filename) throws Exception {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (EnumBasedSingletonEnum) ois.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        String filename = "singleton.bin";
        // EnumBasedSingletonEnum singleton = EnumBasedSingletonEnum.INSTANCE;
        // singleton.setValue(111);
        // saveToFile(singleton, filename);
        EnumBasedSingletonEnum singleton2 = readFromFile(filename);
        System.out.println(singleton2.getValue());
    }
}
