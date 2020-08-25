package temporary;

public class BananaStorage extends FruitStorage {
    private static BananaStorage instance;

    private BananaStorage() {
    }

    public static synchronized BananaStorage getInstance() {
        BananaStorage singleton = instance;
        if (singleton != null) {
            return singleton;
        }
        synchronized (BananaStorage.class) {
            if (instance == null) {
                instance = new BananaStorage();
            }
            return instance;
        }
    }
}
