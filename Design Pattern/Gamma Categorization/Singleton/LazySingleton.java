public class LazySingleton {
    private static LazySingleton INSTANCE;    

    private LazySingleton() {
        System.out.println("Initializing a singleton");
    }

    // this is not thread safe - if two threads call this method at the same time, they will both create a new instance
    // we need to make it thread safe by using synchronized keyword
    // but this is not efficient because every time we call this method, we need to synchronize the whole method
    // we can use double check locking to make it more efficient
    // double check locking is a technique where we check if the instance is null and then synchronize the method
    // if the instance is not null, we return the instance
    // if the instance is null, we synchronize the method and create a new instance
    // this is more efficient because we only synchronize the method if the instance is null
    // but this is not thread safe because if two threads call this method at the same time, they will both create a new instance
    // public static synchronized LazySingleton getInstance() {
    //     if (INSTANCE == null) {
    //         INSTANCE = new LazySingleton();
    //     }
    //     return INSTANCE;
    // }

    // double check locking 
    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (LazySingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazySingleton();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        LazySingleton singleton = LazySingleton.getInstance();
        System.out.println(singleton);
    }
}
