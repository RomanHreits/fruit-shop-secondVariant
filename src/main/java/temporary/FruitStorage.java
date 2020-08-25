package temporary;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class FruitStorage {
    private Map<LocalDate, Integer> storage;

    public FruitStorage() {
        storage = new HashMap<>();
    }

    public Map<LocalDate, Integer> getStorage() {
        return storage;
    }

    public void setStorage(Map<LocalDate, Integer> storage) {
        this.storage = storage;
    }
}
