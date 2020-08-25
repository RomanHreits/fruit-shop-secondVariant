package temporary;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class BuyFruits implements FruitStoreOperations {
    @Override
    public void action(FruitStorage fruitStorage, String[] array) {
        LocalDate currentDate = LocalDate.parse(array[array.length - 1]);
        Map<LocalDate, Integer> storage = fruitStorage.getStorage();

        if (storage.isEmpty()) {
            throw new IllegalArgumentException(String
                    .format("There is no %s in the storage", array[1]));
        }
        fruitStorage.setStorage(getDataFromStorage(storage, currentDate,
                Integer.parseInt(array[2])));
    }

    private Map<LocalDate, Integer> getDataFromStorage(Map<LocalDate, Integer> storage, LocalDate currentDate, Integer quantity) {
        int fruitCount = 0;
        Map<LocalDate, Integer> newMap = new HashMap<>(storage);
        Set<LocalDate> localDates = new TreeSet<>(storage.keySet());
        for (LocalDate storageDate : localDates) {
            if (currentDate.isBefore(storageDate)) {
                fruitCount += storage.get(storageDate);
                if (fruitCount > quantity) {
                    newMap.put(storageDate, fruitCount - quantity);
                    System.out.println("Operation executed");
                    return newMap;
                }
                newMap.remove(storageDate);
            }
        }
        return new HashMap<>();
    }
}

