package temporary;

public class OrangeStorage extends FruitStorage {
    public static OrangeStorage instance;

    public OrangeStorage() {
    }

    public static OrangeStorage getInstance() {
        OrangeStorage singleton = instance;
        if (singleton != null) {
            return singleton;
        }
        synchronized (OrangeStorage.class) {
            if (instance == null) {
                instance = new OrangeStorage();
            }
            return instance;
        }
    }
}
