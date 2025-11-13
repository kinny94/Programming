public class InnerStaticSingleton {
    private InnerStaticSingleton() {
        System.out.println("Initializing a singleton");
    }
    // This is a lazy singleton - it is initialized only when the class is loaded
    // This is thread safe because the class is loaded by the class loader and the class loader is thread safe
    // This is also efficient because the class is initialized only when the class is loaded
    // This is also a singleton because the class is initialized only once
    // This is also a singleton because the class is initialized only once
    private static class Impl {
        private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
    }

    public static InnerStaticSingleton getInstance() {
        return Impl.INSTANCE;
    }

    public static void main(String[] args) {
        InnerStaticSingleton singleton = InnerStaticSingleton.getInstance();
        System.out.println(singleton);
    }
}
