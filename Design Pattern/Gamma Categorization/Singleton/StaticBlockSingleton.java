import java.io.File;
import java.io.IOException;

public class StaticBlockSingleton {
    private StaticBlockSingleton() throws IOException {
        System.out.println("Initializing a singleton");
        File.createTempFile("singleton", ".bin");
    }

    private static StaticBlockSingleton INSTANCE;

    static {
        try {
            INSTANCE = new StaticBlockSingleton();
        } catch (IOException e) {
            System.out.println("Error creating singleton");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        StaticBlockSingleton singleton = StaticBlockSingleton.getInstance();
        System.out.println(singleton);
    }
}
