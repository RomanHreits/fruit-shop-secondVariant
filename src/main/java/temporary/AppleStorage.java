package temporary;

public class AppleStorage extends FruitStorage {
    private static AppleStorage instance;

    private AppleStorage() {
    }

    public static AppleStorage getInstance() {
        AppleStorage singleton = instance;
        if (singleton != null) {
            return singleton;
        }
        synchronized (AppleStorage.class) {
            if (instance == null) {
                instance = new AppleStorage();
            }
            return instance;
        }
    }
}
