package temporary;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;

public class SupplyFruits implements FruitStoreOperations {
    @Override
    public void action(FruitStorage fruitStorage, String[] array) {
        Map<LocalDate, Integer> map = fruitStorage.getStorage();
        LocalDate localDate;
        int parseInt;
        try {
            localDate = LocalDate.parse(array[array.length - 1]);
            parseInt = Integer.parseInt(array[2]);
        } catch (NumberFormatException | DateTimeParseException e) {
            throw new IllegalArgumentException("Wrong parameters!!!");
        }
        if (map.isEmpty()) {
            map.put(localDate, parseInt);
            return;
        }
        Integer integer = map.get(localDate) == null ? 0 : map.get(localDate);
        map.put(localDate, parseInt + integer);
    }
}

